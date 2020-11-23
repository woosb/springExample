package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TestClass testClass;
	
	public HomeController() {
		System.out.println("HomeController 생성자 실행");
		//모든 객체가 만들어진 후에 @Autowired 가 실행된다.
		System.out.println("생성자 testClass :  " + testClass); // null 
		
		/*
		String config = "classpath:config/context-config.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		testClass = ctx.getBean("testClass", TestClass.class);
		testClass.print();
		 */
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		System.out.println("생성자 testClass :  " + testClass);
		testClass.print();
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

}
