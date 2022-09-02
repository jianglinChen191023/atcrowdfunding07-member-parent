package com.atguigu.crowd.handler;

import com.atguigu.crowd.entity.vo.ProjectVO;
import com.atguigu.crowd.service.api.ProjectService;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * @param memberId 会员 id
     * @return
     */
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

}
