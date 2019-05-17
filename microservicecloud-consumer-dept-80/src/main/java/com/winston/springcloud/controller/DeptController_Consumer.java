package com.winston.springcloud.controller;

import com.winston.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Winston
 * @title: DeptController_Consumer
 * @projectName microservicecloud
 * @description:
 * @date 2019/5/17 17:19
 */
@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {

    private static final String REST_URL_PERFIX = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<Dept> getDept(){
        return restTemplate.getForObject(REST_URL_PERFIX+"/dept", List.class);
    }

    @GetMapping("/{id}")
    public Dept getById(@PathVariable("id") Long id){
        return  restTemplate.getForObject(REST_URL_PERFIX+"/dept/"+id, Dept.class);
    }

    @PostMapping
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PERFIX+"/dept", dept, Boolean.class);
    }

}
