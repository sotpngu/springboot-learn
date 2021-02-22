package com.example.learn.aspect;

import com.example.learn.pojo.User;
import com.example.learn.service.UserService1;
import com.example.learn.service.impl.UserServiceImpl;
import com.example.learn.validator.UserValidator;
import com.example.learn.validator.impl.UserValidatorImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    /**
     * 切面定义
     * */
    //@Before("execution(* com.example.learn.service.impl.UserServiceImpl.printUser(..))")
    //public void before() {
    //    System.out.println("before myAspect ......");
    //}
    //
    //@After("execution(* com.example.learn.service.impl.UserServiceImpl.printUser(..))")
    //public void after() {
    //    System.out.println("after myAspect ......");
    //}
    //
    //@AfterReturning("execution(* com.example.learn.service.impl.UserServiceImpl.printUser(..))")
    //public void AfterReturning() {
    //    System.out.println("AfterReturning myAspect ......");
    //}
    //
    //@AfterThrowing("execution(* com.example.learn.service.impl.UserServiceImpl.printUser(..))")
    //public void AfterThrowing() {
    //    System.out.println("AfterThrowing myAspect ......");
    //}


    /**
     * 切点定义
     * */
    @Pointcut("execution(* com.example.learn.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {
    }

    @Before("pointCut() && args(user)")
    public void before(JoinPoint joinPoint, User user) {
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            User user1 = (User) args[i];
            System.out.println("获取到的user的id：" + user.getId());
        }
        System.out.println("before myAspect ......");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after myAspect ......");
    }

    @AfterReturning("pointCut()")
    public void AfterReturning() {
        System.out.println("AfterReturning myAspect ......");
    }

    @AfterThrowing("pointCut()")
    public void AfterThrowing() {
        System.out.println("AfterThrowing myAspect ......");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before myAspect ......");
        joinPoint.proceed();
        System.out.println("around after myAspect ......");
    }

    @DeclareParents(value = "com.example.learn.service.impl.UserServiceImpl", defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;


}
