package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 项目数据:
 * - 首页 > 项目详情页面 {项目数据: [回报数据]}
 *
 * @author 陈江林
 * @date 2022/9/4 21:52
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DetailProjectVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目主键
     */
    private Integer projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目简介
     */
    private String projectDesc;

    /**
     * 多少人关注
     */
    private Integer followerCount;

    /**
     * 筹集天数
     */
    private Integer day;

    /**
     * [{0: 审核中}, {1: 众筹中}, {2: 众筹成功}, {3: 众筹失败}]
     */
    private Integer status;

    /**
     * 对应 status 对象值
     */
    private String statusText;

    /**
     * 筹集多少钱
     */
    private Integer money;

    /**
     * 已经筹集多少钱
     */
    private Integer supportMoney;

    /**
     * 筹集百分比
     */
    private Integer percentage;

    /**
     * 项目发起时间
     */
    private String deployDate;

    /**
     * 还剩多少天
     */
    private Integer lastDay;

    /**
     * 有多少人支持
     */
    private Integer supporterCount;

    /**
     * 头图路径
     */
    private String headerPicturePath;

    /**
     * 详情图片路径
     */
    private List<String> detailPicturePathList;

    /**
     * 回报信息
     */
    private List<DetailReturnVO> detailReturnVOList;

}
