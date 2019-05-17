package com.winston.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Winston
 * @title: Dept 部门
 * @projectName microservicecloud
 * @description:
 * @date 2019/5/17 14:35
 */
@Data
// 全参构造函数
@AllArgsConstructor
// 空参构造函数
@NoArgsConstructor
// @Accessors 注解用来配置lombok如何产生和显示getters和setters的方法,
// chain的中文含义是链式的 一个布尔值。如果为真，产生的setter返回的this而不是void
@Accessors(chain = true)
public class Dept2 implements Serializable {

    private Long deptno;
    private String dname;
    // 来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
    private String dbSource;

    public Dept2(String dname){
        super();
        this.dname = dname;
    }

//    public static void main(String[] args) {
//        Dept dept = new Dept();
//        // 链式写法
//        dept.setDeptno(11L).setDname("RD").setDbSource("DB01");
//        System.out.println(dept);
//    }

}
