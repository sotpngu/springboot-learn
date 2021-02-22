package com.example.learn.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Aspect
//@Order(1)
public class MyAspect3 implements Ordered {

    // 制定顺序
    @Override
    public int getOrder() {
        return 1;
    }

    @Pointcut("execution(* com.example.learn.service.impl.UserServiceImpl.manyAspects(..))")
    public void manyAspects() {
        
    }
    
    @Before("manyAspects()")
    public void before() {
        System.out.println("MyAspect3 before ......");
    }
    
    @After("manyAspects()")
    public void after() {
        System.out.println("MyAspect3 after ......");
    }
    
    @AfterReturning("manyAspects()")
    public void afterReturning() {
        System.out.println("MyAspect3 afterReturning ......");
    }
    
}
