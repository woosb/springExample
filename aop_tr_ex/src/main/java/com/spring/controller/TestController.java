package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.service.TestServiceImpl;

@Controller
public class TestController {
	
	@Autowired TestServiceImpl ts;
	
	@GetMapping(value="buy_form")
	public String buy_form() {
		System.out.println("buyForm 시작");
		return "buy_form";
	}
	
	@PostMapping("buy")
	public String buy( Model model, 
			@RequestParam(value="num", required =false, defaultValue = "0") int num) {
		
		ts.buy(model, num);
		return "result";
	}
	
	@RequestMapping("db_result")
	public String db_result(Model model) {
		ts.db_result(model);
		return "db_result";
	}
	
	@RequestMapping("testChart")
	public String testChart(Model model) {
		return "testChart";
	}
}
