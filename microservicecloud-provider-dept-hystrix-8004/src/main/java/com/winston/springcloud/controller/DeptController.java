package com.winston.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    // 指向下方的熔断器回调方法
    // 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类的指定方法
    // 高度耦合的方式，即添加@HystrixCommand(fallbackMethod = "process_Get")和相应方法
    @HystrixCommand(fallbackMethod = "process_Get")
    public Dept getById(@PathVariable("id") Long id){
        Dept dept = deptService.get(id);
        if(dept==null){
            throw new RuntimeException("该id:"+id+"没有对应信息");
        }
        return deptService.get(id);
    }

    /**
      * @Author Winston
      * @Description 高度耦合的方式
      * hystrix熔断器返回方法
      * @Date 14:35 2019/5/22
      * @Param
      * @return
      **/
    public Dept process_Get(@PathVariable("id")Long id){
        Dept dept = new Dept();
        dept.setDeptno(id);
        dept.setDname("该id:"+id+"没有对应信息");
        dept.setDbsource("no this database in mysql");
        return dept;
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
