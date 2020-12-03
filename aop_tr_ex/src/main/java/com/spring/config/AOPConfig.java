package com.spring.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AOPConfig {
   @Around("execution(* com.spring.controller.TestController.buy_form(..))")
   public void commonAop(ProceedingJoinPoint joinpoint) {
      try {
         System.out.println("=====controller 공통 기능 시작====");
         joinpoint.proceed();
         System.out.println("=====controller 공통 기능 종료====");
      }catch (Throwable e) { e.printStackTrace(); }
   }
}