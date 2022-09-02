package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 发起人确认信息表
 *
 * @author 陈江林
 * @date 2022/8/31 13:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberConfirmInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 易付宝企业账号
     */
    private String paynum;

    /**
     * 法人身份证号
     */
    private String cardnum;

}