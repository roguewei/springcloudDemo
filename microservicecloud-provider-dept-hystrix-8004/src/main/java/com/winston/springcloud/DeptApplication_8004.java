package com.winston.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Winston
 * @title: DeptApplication
 * @projectName microservicecloud
 * @description:
 * @date 2019/5/17 16:41
 */
@SpringBootApplication
// 本服务启动后自动注册进入eureka服务中
@EnableEurekaClient
// 服务发现
@EnableDiscoveryClient
// 对hystrix熔断机制的支持
@EnableCircuitBreaker
public class DeptApplication_8004 {

    public static void main(String[] args) {
        SpringApplication.run(DeptApplication_8004.class, args);
    }

}
