package com.winston.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;

/**
 * @author Winston
 * @title: MySelfRule
 * @projectName microservicecloud
 * @description: 自定义ribbon类不能再@ComponentScan所扫描的当前包及其子包下
 * @date 2019/5/21 11:35
 */
@Configuration
public class MySelfRule{

    @Bean
    public IRule myRule(){
//        return new RandomRule();
        return new RandomRule_NEW();
    }

}
