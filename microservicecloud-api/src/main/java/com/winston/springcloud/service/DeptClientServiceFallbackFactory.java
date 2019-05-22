package com.winston.springcloud.service;

import com.winston.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Winston
 * @title: DeptClientServiceFallbackFactory
 * @projectName microservicecloud
 * @description: 讲熔断处理解耦，不必在每个controller方法上都注解@HystrixCommand又添加fallbackMethod方法
 * @date 2019/5/22 17:21
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {



    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                Dept dept = new Dept();
                dept.setDeptno(id);
                dept.setDname("该id:"+id+"没有对应信息,consumer客户端提供的降级信息，此刻服务provider已经关闭");
                dept.setDbsource("no this database in mysql");
                return dept;
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
