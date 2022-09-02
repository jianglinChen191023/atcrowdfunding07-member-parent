package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 回报信息表
 *
 * @author 陈江林
 * @date 2022/8/31 13:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * t_projcet 项目标识
     */
    private Integer projectid;

    /**
     * [{0: 实物回报}, {1: 虚拟物品回报}]
     */
    private Integer type;

    /**
     * 支持金额
     */
    private Integer supportmoney;

    /**
     * 回报内容
     */
    private String content;

    /**
     * 回报产品限额 {0: 不限额回报数量}
     */
    private Integer count;

    /**
     * 是否设置单笔限购
     */
    private Integer signalpurchase;

    /**
     * 具体限购数量
     */
    private Integer purchase;

    /**
     * 运费 {0: 包邮}
     */
    private Integer freight;

    /**
     * [{0: 不开发票}, {1: 开发票}]
     */
    private Integer invoice;

    /**
     * 项目结束后多少天向支持者发送回报
     */
    private Integer returndate;

    /**
     * 说明图片路径
     */
    private String describPicPath;

}