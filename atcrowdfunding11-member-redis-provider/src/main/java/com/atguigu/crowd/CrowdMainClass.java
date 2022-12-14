package com.atguigu.crowd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * `@EnableCircuitBreaker`: 开启断路器功能
 *
 * @author 陈江林
 * @date 2022/8/19 11:05
 */
@EnableCircuitBreaker
@SpringBootApplication
public class CrowdMainClass {

    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class, args);
    }

}
