package com.winston.springcloud.service;

import com.winston.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 本接口仅访问名称为MICROSERVICECLOUD-DEPT的微服务
@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientService {

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    boolean add(Dept dept);

    @RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
    Dept get(@PathVariable("id") Long id);

    @GetMapping("/dept")
    List<Dept> list();

}
