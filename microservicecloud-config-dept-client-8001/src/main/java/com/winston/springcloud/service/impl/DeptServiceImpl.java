package com.winston.springcloud.service.impl;

import com.winston.springcloud.entities.Dept;
import com.winston.springcloud.entities.DeptExample;
import com.winston.springcloud.mapper.DeptMapper;
import com.winston.springcloud.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Winston
 * @title: DeptServiceImpl
 * @projectName microservicecloud
 * @description:
 * @date 2019/5/17 16:32
 */
@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        int res = deptMapper.insertSelective(dept);
        return res>0;
    }

    @Override
    public Dept get(Long id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.selectByExample(new DeptExample());
    }
}
