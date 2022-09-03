package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 首页展示数据-分类中的项目信息
 *
 * @author 陈江林
 * @date 2022/9/3 20:11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PortalProjectVO {

    private Integer projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 头图路径
     */
    private String headerPicturePath;

    /**
     * 筹集金额
     */
    private Integer money;

    /**
     * 项目发起时间
     */
    private String deployDate;

    /**
     * 已筹集到的金额/筹集金额 百分比
     */
    private String percentage;

    /**
     * 支持人数
     */
    private Integer supporter;

}
