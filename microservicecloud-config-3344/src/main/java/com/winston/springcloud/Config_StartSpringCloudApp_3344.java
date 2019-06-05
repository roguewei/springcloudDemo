package com.winston.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Winston
 * @title: Config_StartSpringCloudApp_3344
 * @projectName microservicecloud
 * @description:
 * @date 2019/6/4 15:48
 */
@SpringBootApplication
@EnableConfigServer
public class Config_StartSpringCloudApp_3344 {

    public static void main(String[] args) {
        SpringApplication.run(Config_StartSpringCloudApp_3344.class, args);
    }

}
