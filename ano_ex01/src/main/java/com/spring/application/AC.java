package com.spring.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AC implements ApplicationContextAware{
	
	public static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("자동으로 실행 된다.");
		this.applicationContext = applicationContext;
		System.out.println(this.applicationContext);
	}
	public ApplicationContext getAC() {
		return applicationContext;
	}
}
