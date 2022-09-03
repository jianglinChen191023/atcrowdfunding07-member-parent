package com.atguigu.crowd.service.impl;

import com.atguigu.crowd.entity.po.MemberConfirmInfoPO;
import com.atguigu.crowd.entity.po.MemberLaunchInfoPO;
import com.atguigu.crowd.entity.po.ProjectPO;
import com.atguigu.crowd.entity.po.ReturnPO;
import com.atguigu.crowd.entity.vo.*;
import com.atguigu.crowd.mapper.*;
import com.atguigu.crowd.service.api.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 陈江林
 * @date 2022/8/31 11:49
 */
@Transactional(readOnly = true)
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectPOMapper projectPOMapper;

    @Autowired
    private ProjectItemPicPOMapper projectItemPicPOMapper;

    @Autowired
    private MemberLaunchInfoPOMapper memberLaunchInfoPOMapper;

    @Autowired
    private MemberConfirmInfoPOMapper memberConfirmInfoPOMapper;

    @Autowired
    private ReturnPOMapper returnPOMapper;

    @Transactional(
            propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class
    )
    @Override
    public void saveProject(ProjectVO projectVO, Integer memberId) {
        // 一、保存 ProjectPO 对象
        // 1. 创建 ProjectPO 对象
        ProjectPO projectPO = new ProjectPO();

        // 2. 把 projectVO 中的属性复制到 ProjectPO 中
        BeanUtils.copyProperties(projectVO, projectPO);

        // 把 memberId 存储到 projectPO 中
        projectPO.setMemberid(memberId);
        // 存储创建时间
        String createdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        projectPO.setCreatedate(createdate);
        // status=0 即将开始
        projectPO.setStatus(0);

        // 3. 保存 projectPO
        // 3.1 为了能够获取到 projectPO 保存后的主键, 需要到 ProjectPOMapper.xml 文件中进行相关的设置
        // 3.1.1 追加 useGeneratedKeys="true" keyProperty="id"
        // - <insert id="insertSelective" useGeneratedKeys="true" keyProperty="id"
        projectPOMapper.insertSelective(projectPO);

        // 4. 获取 projectPO 的 id
        Integer projectId = projectPO.getId();

        // 二、保存项目分类的关联关系信息
        // 1. 从 ProjectVO 对象获取 typeIdList
        List<Integer> typeIdList = projectVO.getTypeIdList();
        projectPOMapper.insertTypeRelationship(typeIdList, projectId);

        // 三、保存项目标签关联关系信息
        List<Integer> tagIdList = projectVO.getTagIdList();
        projectPOMapper.insertTagRelationship(tagIdList, projectId);

        // 四、保存项目中详情图片路径信息
        List<String> detailPicturePathList = projectVO.getDetailPicturePathList();
        projectItemPicPOMapper.insertPathList(detailPicturePathList, projectId);

        // 五、项目发起人信息
        MemberLauchInfoVO memberLauchInfoVO = projectVO.getMemberLauchInfoVO();
        MemberLaunchInfoPO memberLaunchInfoPO = new MemberLaunchInfoPO();
        BeanUtils.copyProperties(memberLauchInfoVO, memberLaunchInfoPO);
        memberLaunchInfoPO.setMemberid(memberId);
        memberLaunchInfoPOMapper.insertSelective(memberLaunchInfoPO);

        // 六、保存项目回报信息
        List<ReturnVO> returnVOList = projectVO.getReturnVOList();
        List<ReturnPO> returnPOList = new ArrayList<>();
        for (ReturnVO returnVO : returnVOList) {
            ReturnPO returnPO = new ReturnPO();
            BeanUtils.copyProperties(returnVO, returnPO);
            returnPOList.add(returnPO);
        }

        returnPOMapper.insertReturnPOBatch(returnPOList, projectId);

        // 七、保存项目确认信息
        MemberConfirmInfoVO memberConfirmInfoVO = projectVO.getMemberConfirmInfoVO();
        MemberConfirmInfoPO memberConfirmInfoPO = new MemberConfirmInfoPO();
        BeanUtils.copyProperties(memberConfirmInfoVO, memberConfirmInfoPO);
        memberConfirmInfoPO.setMemberid(memberId);
        memberConfirmInfoPOMapper.insert(memberConfirmInfoPO);
    }

    @Override
    public List<PortalTypeVO> getPortalTypeVO() {
        return projectPOMapper.selectPortalTypeVOList();
    }

}
