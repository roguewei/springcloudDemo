package com.winston.springcloud.service;

import com.winston.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 本接口仅访问名称为MICROSERVICECLOUD-DEPT的微服务
@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientService {

    @PostMapping("/dept/add")
    boolean add(Dept dept);

    @GetMapping("/dept/{id}")
    Dept get(@PathVariable("id") Long id);

    @GetMapping("/dept")
    List<Dept> list();

}
