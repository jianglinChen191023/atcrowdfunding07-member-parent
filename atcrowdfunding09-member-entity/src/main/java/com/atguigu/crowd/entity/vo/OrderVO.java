package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陈江林
 * @date 2022/9/10 16:14
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 收货地址表主键
     */
    private String addressId;

    /**
     * 订单号
     */
    private String orderName;

    /**
     * 支付宝流水单号
     */
    private String payOrderNum;

    /**
     * 订单金额
     */
    private Double orderAmount;

    /**
     * 是否开发票 [{0: 不开发票}, {1: 开发票}]
     */
    private String invoice;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     * 订单备注
     */
    private String orderRemark;

    private OrderProjectVO orderProjectVO;

}
