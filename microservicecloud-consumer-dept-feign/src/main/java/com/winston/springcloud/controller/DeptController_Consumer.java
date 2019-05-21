package com.winston.springcloud.controller;

import com.winston.springcloud.entities.Dept;
import com.winston.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private DeptClientService service;

    @GetMapping
    public List<Dept> getDept(){
        return service.list();
    }

    @GetMapping("/{id}")
    public Dept getById(@PathVariable("id") Long id){
        return  service.get(id);
    }

    @PostMapping
    public boolean add(Dept dept){
        return service.add(dept);
    }

}
