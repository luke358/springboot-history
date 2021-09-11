package com.zhu.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;


public class log implements MethodBeforeAdvice {

    //mehtod: 要执行的模板对象的方法
    //object： 参数
    //target 目标对象
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"的"+method.getName()+"被执行了");
    }
}
