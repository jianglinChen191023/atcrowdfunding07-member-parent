package com.atguigu.crowd.service.api;

import com.atguigu.crowd.entity.po.AddressPO;
import com.atguigu.crowd.entity.vo.AddressVO;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.entity.vo.OrderVO;
import com.atguigu.crowd.util.ResultEntity;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/9/7 20:16
 */
public interface OrderService {

    /**
     * 获取订单项目视图对象
     *
     * @param returnId  回报id
     * @return {@link ResultEntity}<{@link OrderProjectVO}>
     */
    OrderProjectVO getOrderProjectVO(Integer returnId);

    /**
     * 获取用户的收货地址
     *
     * @param memberId
     * @return {@link List}<{@link AddressVO}>
     */
    List<AddressVO> getAddressVOList(Integer memberId);

    /**
     * 保存收货地址
     *
     * @param addressPO
     */
    void saveAddressPO(AddressPO addressPO);

    /**
     * 保存订单
     *
     * @param orderVO
     */
    void saveOrder(OrderVO orderVO);
}
