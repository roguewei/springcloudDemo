package com.winston.springcloud.controller;

import com.winston.springcloud.entities.Dept;
import com.winston.springcloud.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Winston
 * @title: DeptController
 * @projectName microservicecloud
 * @description:
 * @date 2019/5/17 16:31
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;

    // 服务发现
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    public List<Dept> getAll(){
        return deptService.list();
    }

    @GetMapping("/{id}")
    public Dept getById(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @PostMapping
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @GetMapping("/discovery")
    public Object discovery(){
        // 获取eureka里面的微服务
        List<String> list = discoveryClient.getServices();
        System.out.println("--------"+list);

        List<ServiceInstance>  serviceInstances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance element : serviceInstances){
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getUri());
        }
        return this.discoveryClient;
    }


}
