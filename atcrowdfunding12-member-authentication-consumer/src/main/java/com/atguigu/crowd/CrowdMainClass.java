package com.atguigu.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * `@EnableFeignClients` 启用 Feign 客户端功能
 * `@EnableDiscoveryClient` 当前版本可以不写
 *
 * @author 陈江林
 * @date 2022/8/28 21:51
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }

}