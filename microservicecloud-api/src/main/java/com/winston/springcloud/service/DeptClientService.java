package com.winston.springcloud.service;

import com.winston.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptClientService {

    @PostMapping
    boolean add(Dept dept);

    @GetMapping(value = "/{id}")
    Dept get(@PathVariable("id") Long id);

    @GetMapping
    List<Dept> list();

}
