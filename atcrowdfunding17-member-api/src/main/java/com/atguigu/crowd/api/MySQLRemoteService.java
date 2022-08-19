package com.atguigu.crowd.api;

import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenjianglin
 * @date 2022/8/19 09:05
 */
@FeignClient("atguigu-crowd-mysql")
public interface MySQLRemoteService {

    /**
     * 根据账号查询
     *
     * @param loginacc 账号
     * @return
     */
    @RequestMapping("/get/memberpo/login/acct/remote")
    ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacc") String loginacc);

}
