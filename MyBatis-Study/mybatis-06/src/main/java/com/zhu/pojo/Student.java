package com.zhu.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;

    //学生要关联一个老师
    private Teacher teacher;
}
