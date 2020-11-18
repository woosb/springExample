package com.spring.ex03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		String path = "classpath:applicationST.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		
		PrintBean pb = (PrintBean)ctx.getBean("pb");
		pb.setPrint("Asd");
		pb.print();
		
	}
}
