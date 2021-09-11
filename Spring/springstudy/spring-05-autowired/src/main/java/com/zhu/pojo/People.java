package com.zhu.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

@Data
public class People {

    @Resource(name = "cat1")
    private Cat cat;

    @Autowired
    private Dog dog;
    private String name;
}
