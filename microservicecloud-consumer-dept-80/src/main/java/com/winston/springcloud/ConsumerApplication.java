package com.winston.springcloud;

import com.winston.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Winston
 * @title: ConsumerApplication
 * @projectName microservicecloud
 * @description:
 * @date 2019/5/17 17:30
 */
@SpringBootApplication
@EnableEurekaClient
// 对哪个微服务使用哪种负载均衡方式
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class)
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
