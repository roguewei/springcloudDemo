package com.winston.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Winston
 * @title: EurekaServerApplication
 * @projectName microservicecloud
 * @description:
 * @date 2019/5/18 9:45
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication_7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication_7001.class, args);
    }

}
