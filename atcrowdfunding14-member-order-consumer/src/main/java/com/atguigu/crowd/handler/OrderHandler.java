package com.atguigu.crowd.handler;

import com.atguigu.crowd.api.MySQLRemoteService;
import com.atguigu.crowd.constant.CrowdConstant;
import com.atguigu.crowd.entity.po.AddressPO;
import com.atguigu.crowd.entity.vo.AddressVO;
import com.atguigu.crowd.entity.vo.MemberLoginVO;
import com.atguigu.crowd.entity.vo.OrderProjectVO;
import com.atguigu.crowd.util.ResultEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 陈江林
 * @date 2022/9/7 19:32
 */
@Controller
public class OrderHandler {

    @Autowired
    private MySQLRemoteService mySQLRemoteService;

    /**
     * 首页 -> 项目详情（点击支持） -> 显示回报确认信息
     *
     * @param returnId
     * @param session
     * @return {@link String}
     */
    @RequestMapping("/confirm/return/info/{returnId}")
    public String showReturnConfirmInfo(@PathVariable("returnId") Integer returnId,
                                        HttpSession session) {
        // 查询数据
        ResultEntity<OrderProjectVO> resultEntity = mySQLRemoteService.getOrderProjectVORemote(returnId);

        // 判断查询结果
        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            OrderProjectVO orderProjectVO = resultEntity.getData();

            // 为了能够在后续操作中保存 orderProjectVO 数据, 存入 Session 域中
            session.setAttribute("orderProjectVO", orderProjectVO);
        }

        return "confirm_return";
    }

    /**
     * 首页 -> 项目详情（点击支持） -> 显示回报确认信息 -> 显示返回确认信息
     *
     * @param returnCount 回报数量
     * @param session
     * @return {@link String}
     */
    @RequestMapping("/confirm/order/{returnCount}")
    public String showReturnOrderInfo(@PathVariable("returnCount") Integer returnCount,
                                      HttpSession session) {
        // 1. 把接收到的回报数量合并到 Session 域
        OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");
        orderProjectVO.setReturnCount(returnCount);
        session.setAttribute("orderProjectVO", orderProjectVO);

        // 2. 获取当前已登录用户的 id
        MemberLoginVO memberLoginVO = (MemberLoginVO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
        Integer memberId = memberLoginVO.getId();

        // /3.查询目前的收货地址数据
        ResultEntity<List<AddressVO>> resultEntity = mySQLRemoteService.getAddressVOListRemote(memberId);
        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            List<AddressVO> addressVOList = resultEntity.getData();
            session.setAttribute("addressVOList", addressVOList);
        }

        return "confirm_order";
    }

    /**
     * 首页 -> 项目详情（点击支持） -> 显示回报确认信息 -> 显示返回确认信息（收货地址, 点击确认配送信息）
     *
     * @param addressVO
     * @return {@link ResultEntity}<{@link AddressVO}>
     */
    @ResponseBody
    @RequestMapping("/save/address")
    public ResultEntity<AddressVO> saveAddressPO(@RequestBody AddressVO addressVO) {
        // 创建一个持久化对象
        AddressPO addressPO = new AddressPO();
        // 复制属性
        BeanUtils.copyProperties(addressVO, addressPO);
        // 保存
        ResultEntity<AddressPO> resultEntity = mySQLRemoteService.saveAddressPORemote(addressPO);
        if (ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            // 执行成功， 复制持久化对象给视图对象并返回
            // 保存成功会有一个 id 值, 所以要复制
            BeanUtils.copyProperties(addressPO, addressVO);
            return ResultEntity.successWithData(addressVO);
        } else {
            return ResultEntity.failed(resultEntity.getMessage());
        }
    }

}
