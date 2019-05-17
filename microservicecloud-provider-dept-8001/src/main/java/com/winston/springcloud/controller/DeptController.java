package com.winston.springcloud.controller;

import com.winston.springcloud.entities.Dept;
import com.winston.springcloud.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
