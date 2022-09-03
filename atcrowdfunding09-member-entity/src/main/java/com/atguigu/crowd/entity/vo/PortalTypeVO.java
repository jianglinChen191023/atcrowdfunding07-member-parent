package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 首页展示数据
 *
 * @author 陈江林
 * @date 2022/9/3 20:10
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PortalTypeVO {

    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类说明
     */
    private String remark;

    /**
     * 首页展示数据-分类中的项目信息
     */
    private List<PortalProjectVO> portalProjectVO;

}
