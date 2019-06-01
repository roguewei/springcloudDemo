package com.winston.springcloud.service;

import com.winston.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @FeignClient注明本接口仅访问名称为MICROSERVICECLOUD-DEPT的微服务
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")

// 添加熔断处理，本接口中任何方法出了问题都用 DeptClientServiceFallbackFactory 处理
@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    /**
      * @Author Winston
      * @Description 接口方式实现微服务负载均衡
      * 该方法表明调用服务名为MICROSERVICECLOUD-DEPT下的/dept/add服务
      * @Date 9:31 2019/5/28
      * @Param
      * @return
      **/
    @PostMapping("/dept/add")
    boolean add(Dept dept);

    @GetMapping("/dept/{id}")
    Dept get(@PathVariable("id") Long id);

    @GetMapping("/dept")
    List<Dept> list();

}
