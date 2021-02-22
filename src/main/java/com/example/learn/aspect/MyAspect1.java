package com.example.learn.aspect;

import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect1 {

    @Pointcut("execution(* com.example.learn.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects() {

    }

    @Before("manyAspects()")
    public void before() {
        System.out.println("MyAspect1 before ......");
    }

    @After("manyAspects()")
    public void after() {
        System.out.println("MyAspect1 after ......");
    }

    @AfterReturning("manyAspects()")
    public void afterReturning() {
        System.out.println("MyAspect1 afterReturning ......");
    }

}
