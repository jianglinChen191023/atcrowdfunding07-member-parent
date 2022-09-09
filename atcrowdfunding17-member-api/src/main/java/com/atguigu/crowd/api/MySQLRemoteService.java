package com.atguigu.crowd.api;

import com.atguigu.crowd.entity.po.AddressPO;
import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.vo.*;
import com.atguigu.crowd.factory.MySQLFallBackFactory;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/8/19 09:05
 */
@FeignClient(value = "atguigu-crowd-mysql", fallbackFactory = MySQLFallBackFactory.class)
public interface MySQLRemoteService {

    /**
     * 根据账号查询
     *
     * @param loginacct 账号
     * @return
     */
    @RequestMapping("/get/memberpo/login/acct/remote")
    ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct);

    /**
     * 保存
     *
     * @param memberPO 会员实体类
     * @return
     */
    @RequestMapping("/save/member/remote")
    ResultEntity<String> saveMember(@RequestBody MemberPO memberPO);

    /**
     * 保存会员发起的众筹信息
     *
     * @param projectVO 众筹信息
     * @param memberId  会员 id
     * @return
     */
    @RequestMapping("/save/project/vo/remote")
    ResultEntity<String> saveProjectVORemote(@RequestBody ProjectVO projectVO, @RequestParam("memberId") Integer memberId);

    /**
     * 查询首页数据
     *
     * @return
     */
    @RequestMapping("/get/portal/type/project/data/remote")
    ResultEntity<List<PortalTypeVO>> getPortalTypeProjectDataRemote();

    /**
     * 查询首页 > 项目详情页面数据
     *
     * @param projectId 项目 id
     * @return
     */
    @RequestMapping("/get/project/detail/remote/{projectId}")
    ResultEntity<DetailProjectVO> getDetailProjectVORemote(@PathVariable("projectId") Integer projectId);

    /**
     * 获取订单项目
     *
     * @param returnId 回报id
     * @return {@link ResultEntity}<{@link OrderProjectVO}>
     */
    @RequestMapping("/get/order/project/vo/remote/{returnId}")
    ResultEntity<OrderProjectVO> getOrderProjectVORemote(@PathVariable("returnId") Integer returnId);

    /**
     * 获取用户的收货地址
     *
     * @param memberId
     * @return {@link ResultEntity}<{@link List}<{@link AddressVO}>>
     */
    @RequestMapping("/get/address/vo/list/remote")
    ResultEntity<List<AddressVO>> getAddressVOListRemote(@RequestParam("memberId") Integer memberId);

    /**
     * 保存收货地址
     *
     * @param addressPO
     * @return {@link ResultEntity}<{@link AddressPO}>
     */
    @RequestMapping("/save/address/po/remote")
    ResultEntity<AddressPO> saveAddressPORemote(@RequestBody AddressPO addressPO);

}
