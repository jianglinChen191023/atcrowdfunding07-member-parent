package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.po.MemberPO;

/**
 * @author chenjianglin
 * @date 2022/8/19 09:15
 */
public interface MemberService {

    /**
     * 根据账号查询
     *
     * @param loginacct 账号
     * @return
     */
    MemberPO getMemberPOByLoginAcct(String loginacct);

}
