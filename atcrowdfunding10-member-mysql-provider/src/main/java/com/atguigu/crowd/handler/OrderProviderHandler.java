package com.atguigu.crowd.handler;

import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.po.AddressPO;
import com.atguigu.crowd.entity.vo.AddressVO;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.service.api.OrderService;
import com.atguigu.crowd.util.ResultEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈江林
 * @date 2022/9/7 20:15
 */
@RestController
public class OrderProviderHandler {

    @Autowired
    private OrderService orderService;

    @HystrixCommand(fallbackMethod = "getOrderProjectVORemoteBackup")
    @RequestMapping("/get/order/project/vo/remote/{returnId}")
    ResultEntity<OrderProjectVO> getOrderProjectVORemote(@PathVariable("returnId") Integer returnId) {
        try {
            OrderProjectVO orderProjectVO = orderService.getOrderProjectVO(returnId);
            return ResultEntity.successWithData(orderProjectVO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    ResultEntity<OrderProjectVO> getOrderProjectVORemoteBackup(@PathVariable("returnId") Integer returnId) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    @HystrixCommand(fallbackMethod = "getAddressVOListRemoteBackup")
    @RequestMapping("/get/address/vo/list/remote")
    ResultEntity<List<AddressVO>> getAddressVOListRemote(@RequestParam("memberId") Integer memberId) {
        try {
            List<AddressVO> addressVOList = orderService.getAddressVOList(memberId);
            return ResultEntity.successWithData(addressVOList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    ResultEntity<List<AddressVO>> getAddressVOListRemoteBackup(@RequestParam("memberId") Integer memberId) {
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

    @HystrixCommand(fallbackMethod = "saveAddressPORemoteBackup")
    @RequestMapping("/save/address/po/remote")
    public ResultEntity<AddressPO> saveAddressPORemote(@RequestBody AddressPO addressPO){
        try {
            orderService.saveAddressPO(addressPO);
            return ResultEntity.successWithData(addressPO);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }

    public ResultEntity<AddressPO> saveAddressPORemoteBackup(@RequestBody AddressPO addressPO){
        return ResultEntity.failed(CrowdConstant.MESSAGE_HYSTRIX_BACKUP);
    }

}
