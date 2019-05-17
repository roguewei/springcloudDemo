package com.winston.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Winston
 * @title: DBConfig
 * @projectName microservicecloud
 * @description:
 * @date 2019/5/17 16:34
 */
@Configuration
@MapperScan(basePackages = "com.winston.springcloud.mapper",sqlSessionFactoryRef = "sqlSessionFactory")
public class DBConfig {
}
