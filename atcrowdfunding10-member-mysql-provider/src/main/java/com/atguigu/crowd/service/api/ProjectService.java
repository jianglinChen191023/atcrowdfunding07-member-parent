package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.vo.ProjectVO;

/**
 * @author 陈江林
 * @date 2022/8/31 11:49
 */
public interface ProjectService {

    /**
     * 保存会员发起的众筹信息
     *
     * @param projectVO 众筹信息
     * @param memberId 会员 id
     * @return
     */
    void saveProject(ProjectVO projectVO, Integer memberId);

}
