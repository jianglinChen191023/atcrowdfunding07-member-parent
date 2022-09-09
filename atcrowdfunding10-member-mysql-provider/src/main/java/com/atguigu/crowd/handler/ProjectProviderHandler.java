package com.atguigu.crowd.handler;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.vo.DetailProjectVO;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import com.atguigu.crowd.entity.vo.ProjectVO;
import com.atguigu.crowd.service.api.ProjectService;
import com.atguigu.crowd.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/8/31 11:49
 */
@RestController
public class ProjectProviderHandler {

    @Autowired
    private ProjectService projectService;

    /**
     * 保存会员发起的众筹信息
     *
     * @param projectVO 众筹信息
     * @param memberId  会员 id
     * @return
     */
    @HystrixCommand(fallbackMethod = "saveProjectVORemoteBackup")
    @RequestMapping("/save/project/vo/remote")
    public ResultEntity<String> saveProjectVORemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId) {
        try {
            projectService.saveProject(projectVO, memberId);
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<String> saveProjectVORemoteBackup(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    @HystrixCommand(fallbackMethod = "getPortalTypeProjectDataRemoteBackup")
    @RequestMapping("/get/portal/type/project/data/remote")
    public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote() {

        try {
            List<PortalTypeVO> portalTypeVOList = projectService.getPortalTypeVO();
            return ResultEntity.successWithData(portalTypeVOList);
        } catch (Exception e) {
            return ResultEntity.failed(e.getMessage());
        }

    }

    public ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemoteBackup() {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    @HystrixCommand(fallbackMethod = "getDetailProjectVORemoteBackup")
    @RequestMapping("/get/project/detail/remote/{projectId}")
    ResultEntity<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId) {

        try {
            DetailProjectVO detailProjectVOById = projectService.getDetailProjectVO(projectId);
            return ResultEntity.successWithData(detailProjectVOById);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }

    }

    ResultEntity<DetailProjectVO> getDetailProjectVORemoteBackup(@PathVariable("projectId") Integer projectId) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

}
