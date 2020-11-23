package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.application.AC;
import com.spring.service.MyService;
import com.spring.service.MyServiceImple;
import com.spring.service.MyServiceImpleB;

@Controller
public class TestController {
	
//	@Autowired
//	private MyService service;
//	@Autowired
//	private MyServiceImple serviceImple;
//	@Autowired
//	private MyServiceImpleB serviceImpleB;
	
	private MyService service;
//	private ApplicationContext ac = AC.applicationContext;
	
	@Autowired
	private AC ac;
	
	@RequestMapping("test")
	public void test() {
//		service = new MyServiceImple();
//		service.execute();
	}
	@RequestMapping("test1")
	public void test1() {
//		service = new MyServiceImple();
//		serviceImple.execute();
		System.out.println(ac);
		service = (MyServiceImple)ac.getAC().getBean("myServiceImple");
		service.execute();
	}
	@RequestMapping("test2")
	public void test2() {
//		service = new MyServiceImple();
//		serviceImpleB.execute();
		service = (MyServiceImpleB)ac.getAC().getBean("myServiceImpleB");
		service.execute();
	}
}
