package com.zhu.diy;

//使用注解实现AOP

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect //标注这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* com.zhu.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("方法执行前");
    }

    @After("execution(* com.zhu.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("====方法后");
    }

    @Around("execution(* com.zhu.service.UserServiceImpl.*(..))")
    public void Around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");

//        Signature signature = joinPoint.getSignature();
//        System.out.println("signature"+signature);
        //执行方法
        Object proceed = joinPoint.proceed();

        System.out.println("环绕后");

//        System.out.println(proceed);
    }
}
