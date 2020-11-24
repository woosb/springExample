package com.spring.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.TestDTO;
import com.spring.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	TestService ts;
	
	@RequestMapping("/test")
	public void test(Model model) {
		ts.test(model);
	}
	
	@RequestMapping("/inputUserNum")
	public void inputUserNum() {
		
	}
	
	@RequestMapping("/list")
	public void list(Model model, @RequestParam("num") String num) {
		ts.list(model, num);
	}
	
	@RequestMapping("inputdata")
	public void inputdata() {
		
	}
	
	@PostMapping("savedata")
	public String savedata(TestDTO dto) {
		ts.savedata(dto);
		return "redirect:/test";
	}
	
	@RequestMapping("updateform")
	public void udpateform() {
		
	}
	
	@RequestMapping("updatedata")
	public String updatedata(TestDTO dto) {
		ts.updatedata(dto);
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		String myDate = "2020-11-23";
		Date date = null;
		try {
			date = new Date( form.parse(myDate).getTime() );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date);
		return "redirect:/test";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam("num") String num) {
		ts.delete(num);
		return "redirect:/test";
	}
}
