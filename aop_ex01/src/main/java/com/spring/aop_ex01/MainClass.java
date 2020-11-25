package com.spring.aop_ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationAOP_01.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		CoreClass tc = ctx.getBean("core", CoreClass.class);
		
		System.out.println("main start");
		
		tc.corePrint();
		
		System.out.println("main end");
		
		ctx.close();
	}
}
