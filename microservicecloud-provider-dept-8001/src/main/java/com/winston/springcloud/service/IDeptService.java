package com.winston.springcloud.service;

import com.winston.springcloud.entities.Dept;

import java.util.List;

public interface IDeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();

}
