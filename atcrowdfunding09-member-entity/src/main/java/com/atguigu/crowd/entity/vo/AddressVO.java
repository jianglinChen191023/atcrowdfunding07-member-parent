package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 陈江林
 * @date 2022/9/7 22:30
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 收件人
     */
    private String receiveName;

    /**
     * 手机号
     */
    private String phoneNum;

    /**
     * 地址
     */
    private String address;

    /**
     * 会员表主键
     */
    private String memberId;

}
