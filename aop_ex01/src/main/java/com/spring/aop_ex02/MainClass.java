package com.spring.aop_ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path = "classpath:applicationAOP_02.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		CoreClass tc = ctx.getBean("core", CoreClass.class);
		
		System.out.println("main start");
		
		tc.corePrint();
		tc.corePrint02();
		
		tc.test();
		System.out.println("main end");
		
		ctx.close();
	}
}
