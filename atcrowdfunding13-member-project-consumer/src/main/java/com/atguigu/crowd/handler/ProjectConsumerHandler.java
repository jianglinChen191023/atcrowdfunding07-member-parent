package com.atguigu.crowd.handler;

import com.atguigu.crowd.api.MySQLRemoteService;
import com.atguigu.crowd.config.OSSProperties;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.vo.*;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈江林
 * @date 2022/8/31 16:25
 */
@Controller
public class ProjectConsumerHandler {

    @Autowired
    private OSSProperties ossProperties;

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    /**
     * 首页 > 项目详情页面
     *
     * @param projectId
     * @return
     */
    @RequestMapping("/get/project/detail/{projectId}")
    public String getProjectDetail(@PathVariable("projectId") Integer projectId, Model model) {
        ResultEntity<DetailProjectVO> resultEntity = mySQLRemoteService.getDetailProjectVORemote(projectId);

        if(ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            DetailProjectVO detailProjectVO = resultEntity.getData();
            model.addAttribute("detailProjectVO", detailProjectVO);
        }

        return "project-show-detail";
    }

    /**
     * 保存会员发起的众筹信息
     *
     * @param memberConfirmInfoVO
     * @param session
     * @param modelMap
     * @return
     */
    @RequestMapping("/create/confirm")
    public String saveConfirm(
            MemberConfirmInfoVO memberConfirmInfoVO,
            HttpSession session,
            ModelMap modelMap
    ) {
        // 从 Session 域读取之前临时存储的 ProjectVO 对象
        ProjectVO projectVO = (ProjectVO) session.getAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT);

        // 判断 projectVO
        if (projectVO == null) {
            // 如果为空跳转到第一步
            // MESSAGE_DETAIL_CONFIRM = "确认信息失败! 请先填写项目及发起人信息"
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_CONFIRM);
            return "project-launch";
        }

        // 将确认信息数据存储到 ProjectVO 对象中
        projectVO.setMemberConfirmInfoVO(memberConfirmInfoVO);

        // 从 session 中读取当前登录的用户
        MemberLoginVO memberLoginVO = (MemberLoginVO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
        Integer memberId = memberLoginVO.getId();

        // 调用远程方法保存数据
        ResultEntity<String> saveResultEntity = mySQLRemoteService.saveProjectVORemote(projectVO, memberId);
        // 判断远程的保存操作是否成功
        if (ResultEntity.FAILED.equals(saveResultEntity.getResult())) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, saveResultEntity.getMessage());
            return "project-confirm";
        }

        // 将临时的 ProjectVO 对象从 session 中移除
        session.removeAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT);

        // 跳转到完成页面
        return "redirect:" + CrowdConstant.ZUUL_PATH_VALUE + "/project/create/success";
    }

    /**
     * 向 ProjectVO 对象存入回报信息
     *
     * @param returnVO
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/create/save/return.json")
    public ResultEntity<String> returnPicture(
            ReturnVO returnVO,
            HttpSession session
    ) {
        try {
            // 从 session 域中获取之前缓存的 ProjectVO 对象
            ProjectVO projectVO = (ProjectVO) session.getAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT);
            if (null == projectVO) {
                // MESSAGE_TEMPLE_PROJECT_MISSING = 临时存储的 projectVO 对象丢失
                return ResultEntity.failed(CrowdConstant.MESSAGE_TEMPLE_PROJECT_MISSING);
            }

            // 从 projectVO 对象中存储回报信息的集合
            List<ReturnVO> returnVOList = projectVO.getReturnVOList();

            // 判断 returnVOList 集合是否有效
            if (returnVOList == null) {
                returnVOList = new ArrayList<>();
            }

            returnVOList.add(returnVO);

            projectVO.setReturnVOList(returnVOList);
            // 将数据有变化的 ProjectVO 对象重新存入 session 域, 以确保新的数据最终能够存入 Redis
            session.setAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT, projectVO);
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    /**
     * JavaScript 代码: formData.append("returnPicture", file);
     * - returnPicture: 是请求参数的名字
     * - file 是请求参数的值, 也就是要上传的文件
     *
     * @param returnPicture 接收用户上传的文件
     * @return
     */
    @ResponseBody
    @RequestMapping("/create/upload/return/picture.json")
    public ResultEntity<String> uploadReturnPicture(
            @RequestParam("returnPicture") MultipartFile returnPicture
    ) {
        try {
            // 1. 执行文件上传
            ResultEntity<String> returnPictureResultEntity = CrowdUtil.uploadFilterOss(ossProperties.getBucketName(),
                    ossProperties.getEndPoint(),
                    ossProperties.getBucketDomain(),
                    ossProperties.getAccessKeyId(),
                    ossProperties.getAccessKeySecret(),
                    returnPicture.getInputStream(),
                    returnPicture.getOriginalFilename());

            // 2. 返回上传的结果
            return returnPictureResultEntity;
        } catch (IOException e) {
            return ResultEntity.failed(e.getMessage());
        }
    }

    /**
     * @param projectVO         接收除了上传图片之外的其他put普通数据
     * @param headerPicture     上传的头图
     * @param detailPictureList 上传的详情图片
     * @param session           用来将收集了一部分数据的 ProjectVO 对象存入 session 域
     * @param modelMap          用来在当前操作失败后返回上一个表单页面时携带提示消息
     * @return
     */
    @RequestMapping("/create/project/information")
    public String saveProjectBasicInfo(
            ProjectVO projectVO,
            MultipartFile headerPicture,
            List<MultipartFile> detailPictureList,
            HttpSession session,
            ModelMap modelMap) {
        try {
            // 1. 处理 projectVO 头图, 完成头图上传
            boolean headerPictureEmpty = headerPicture.isEmpty();

            // 1.1 如果没有头图
            if (headerPictureEmpty) {
                // 如果没有头图则返回到表单页面并显示提示消息
                modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_HEADER_PIC_EMPTY);
                return "project-launch";
            }

            // 1.2 如果有头图, 则执行上传
            if (!headerPictureEmpty) {
                ResultEntity<String> uploadHeaderPictureResultEntity = CrowdUtil.uploadFilterOss(ossProperties.getBucketName(),
                        ossProperties.getEndPoint(),
                        ossProperties.getBucketDomain(),
                        ossProperties.getAccessKeyId(),
                        ossProperties.getAccessKeySecret(),
                        headerPicture.getInputStream(),
                        headerPicture.getOriginalFilename());

                String result = uploadHeaderPictureResultEntity.getResult();

                // 1.2.1 判断头图是否上传成功
                if (ResultEntity.SUCCESS.equals(result)) {
                    // 1.2.2 从返回的数据中获取图片访问路径
                    String headerPicturePath = uploadHeaderPictureResultEntity.getData();

                    // 1.2.3 存入 ProjectVO 对象中
                    projectVO.setHeaderPicturePath(headerPicturePath);
                } else {
                    // 1.2.4 如果上传失败则返回到表单页面, 返回提示消息
                    modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_HEADER_PIC_UPLOAD_FAILED);
                    return "project-launch";
                }
            }

            // 2. 处理 projectVO 类中的 detailPicturePathList 详情图片的路径
            // 创建一个用来存放详情图片路径的集合
            List<String> detailPicturePathList = new ArrayList<>();

            // 2.1 如果集合为空
            if (!(detailPictureList != null && detailPictureList.size() > 0)) {
                modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_PIC_EMPTY);
                return "project-launch";
            }

            // 2.2 如果集合不为空则遍历集合
            for (MultipartFile detailPicture : detailPictureList) {
                // 2.2.1 如果为空
                if (detailPicture.isEmpty()) {
                    // 检测到详情图片中单个文件为空则返回错误信息
                    modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_PIC_EMPTY);
                    return "project-launch";
                }

                // 2.2.2 如果不为空
                if (!detailPicture.isEmpty()) {
                    // 2.2.3 执行上传
                    ResultEntity<String> detailUploadResultEntity = CrowdUtil.uploadFilterOss(ossProperties.getBucketName(),
                            ossProperties.getEndPoint(),
                            ossProperties.getBucketDomain(),
                            ossProperties.getAccessKeyId(),
                            ossProperties.getAccessKeySecret(),
                            detailPicture.getInputStream(),
                            detailPicture.getOriginalFilename());

                    // 2.2.4 检查上传结果
                    String detailUploadResult = detailUploadResultEntity.getResult();
                    if (ResultEntity.SUCCESS.equals(detailUploadResult)) {
                        String detailPicturePath = detailUploadResultEntity.getData();
                        // 2.2.5 将上传成功的图片的访问路径存入集合中
                        detailPicturePathList.add(detailPicturePath);
                    } else {
                        // 如果上传失败则返回到表单页面并显示提示消息
                        modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_DETAIL_PIC_UPLOAD_FAILED);
                        return "project-launch";
                    }
                }
            }

            // 2.3 将处理好的集合存入 projectVO 中
            projectVO.setDetailPicturePathList(detailPicturePathList);

            // 3. 将收集的部分数据存入 session 中
            session.setAttribute(CrowdConstant.ATTR_NAME_TEMPLE_PROJECT, projectVO);
        } catch (IOException e) {
            modelMap.addAttribute(CrowdConstant.ATTR_NAME_MESSAGE, e.getMessage());
            return "project-launch";
        }

        // 以完整的路径前往下一个 `2. 回报设置` 的页面
        return "redirect:" + CrowdConstant.ZUUL_PATH_VALUE + "/project/return/info/page";
    }

}
