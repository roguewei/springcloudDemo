package com.winston.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Winston
 * @title: DeptApplication_feign
 * @projectName microservicecloud
 * @description:
 * @date 2019/5/21 17:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.winston.springcloud")
//@ComponentScan("com.winston.springcloud")
public class DeptApplication_feign {

    public static void main(String[] args) {
        SpringApplication.run(DeptApplication_feign.class, args);
    }

}
