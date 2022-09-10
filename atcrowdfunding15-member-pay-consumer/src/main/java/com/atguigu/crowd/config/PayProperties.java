package com.atguigu.crowd.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 陈江林
 * @date 2022/9/10 17:42
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@ConfigurationProperties(prefix = "ali.pay")
public class PayProperties {

    /**
     * 支付宝公钥
     */
    private String alipayPublicKey;

    /**
     * 应用 ID
     */
    private String appId;

    /**
     * 字符编码格式
     */
    private String charset;

    /**
     * 支付宝网关（沙箱环境）
     */
    private String gatewayUrl;

    /**
     * 商户私钥
     */
    private String merchantPrivateKey;

    /**
     * 支付宝服务器主动通知商户服务器里指定的页面 http/https 路径
     * 交易成功后，支付宝通过 post 请求 notifyUrl（商户入参传入），返回异步通知参数。
     */
    private String notifyUrl;

    /**
     * 用户确认支付后，支付宝通过 get 请求 returnUrl（商户入参传入），返回同步返回参数。
     */
    private String returnUrl;

    /**
     * 签名方式
     */
    private String signType;

}
