package com.spring.aop_ex02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CommonClass {
	
	@Around("within(com.spring.aop_ex02.*)")
	public void commonAop(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("==== 공통기능 시작 (aop적용 코드) ====");
			joinpoint.proceed();
			System.out.println("==== 공통기능 시작 (aop종료 코드) ====");
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Before("execution(* com.spring.aop_ex02.CoreClass.test())")
	public void beforeAdvice(JoinPoint joinPoint ) {
		System.out.println("beforeAdvice() 핵심기능 실행전에 실행");
	}
}
