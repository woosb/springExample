package test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Test {
	@Around( "execution(* com.spring.controller.TestController.*(..))" )
	public Object setTest(ProceedingJoinPoint join) throws Throwable {
		System.out.println("controller 실행시 실행 됩니다!! ");
		return join.proceed();
	}
}
