package com.winston.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Winston
 * @title: ConfigBean
 * @projectName microservicecloud
 * @description:
 * @date 2019/5/17 17:16
 */
@Configuration
public class ConfigBean {

    /**
      * @Author Winston
      * @Description RestTemplate提供了多种便捷访问远程http服务的方法
      * 是一种简单便捷的访问restful服务模板类，是spring提供的用于访问rest服务的客户端模板工具集
      * @Date 17:22 2019/5/17
      * @Param
      * @return
      **/
    @Bean
    // 仅添加@LoadBalanced注解即可配置ribbon负载均衡
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    // 重新选择原生负载均衡方式
//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
////        return new RandomRule_NEW();
//    }

}
