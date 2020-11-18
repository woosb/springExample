package com.spring.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String name = "홍길동";
		int age = 20;
		
		String config="classpath:applicationST.xml";
		
		//xml파일을 가져오는 클래스
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		STBean stBean = (STBean)ctx.getBean("stb");
		
		stBean.print();
	}
}
