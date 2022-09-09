package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陈江林
 * @date 2022/9/7 19:09
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderProjectVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 发起人
     */
    private String launchName;

    /**
     * 回报内容
     */
    private String returnContent;

    /**
     * 回报数量
     */
    private Integer returnCount;

    /**
     * 支持单价
     */
    private Integer supportPrice;

    /**
     * 配送费用
     */
    private Integer freight;

    /**
     * 订单表主键
     */
    private String orderId;

    /**
     * 是否设置单笔限购
     */
    private Integer signalPurchase;

    /**
     * 具体限购数量
     */
    private Integer purchase;

}
