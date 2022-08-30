package com.atguigu.crowd.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 陈江林
 * @date 2022/8/30 20:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class OSSProperties {

    /**
     * Bucket 名称
     */
    private String bucketName;

    /**
     * 地域节点
     */
    private String endPoint;

    /**
     * Bucket 域名
     */
    private String bucketDomain;

    /**
     * 访问标识
     */
    private String accessKeyId;

    /**
     * 访问秘钥
     */
    private String accessKeySecret;

}
