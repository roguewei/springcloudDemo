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
// 对哪个微服务使用哪种负载均衡方式（自定义负载均衡类不能在当前包及其子包下，需要用@RibbonClient去引用）
// 如果在当前包及其子包下重新选择原生的负载均衡方法则可以不用该@RibbonClient注解，直接定义bean就可以
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = MySelfRule.class)
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
