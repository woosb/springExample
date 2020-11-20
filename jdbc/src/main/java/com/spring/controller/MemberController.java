package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.service.JdbcContentServiceImpl;
import com.spring.service.JdbcDeleteServiceImpl;
import com.spring.service.JdbcModifySaveServiceImpl;
import com.spring.service.JdbcModifyServiceImpl;
import com.spring.service.JdbcSaveServiceImpl;
import com.spring.service.JdbcService;

@Controller
public class MemberController {
	private JdbcService service;
	
	public static JdbcTemplate template;
	
	public MemberController(){
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		template = ctx.getBean("template", JdbcTemplate.class);
	}
	
	@RequestMapping("/content")
	public String content(Model model) {
		service = new JdbcContentServiceImpl();
		service.execute(model);
		
		return "jdbc_test/content";
	}
	
	@GetMapping("/save_view")
	public String save_view() {
		return"jdbc_test/save_view";
	}
	
	@RequestMapping("/save")
	public String save(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("name"));
		service = new JdbcSaveServiceImpl();
		service.execute(model);
		return "redirect:content";
	}
	
	@RequestMapping("/modify")
	public String modify(@RequestParam(value="id") String id,
			HttpServletRequest request ,Model model) {
		model.addAttribute("request", request);
		service = new JdbcModifyServiceImpl();
		service.execute(model);
		
		return "jdbc_test/modify";
	}
	
	@RequestMapping("/modifySave")
	public String modifySave(@RequestParam("id") String id, @RequestParam("name") String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		service = new JdbcModifySaveServiceImpl();
		service.execute(model);
		return "redirect:content";
		
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, @RequestParam("id") String id) {
		model.addAttribute("id", id);
		service = new JdbcDeleteServiceImpl();
		service.execute(model);
		return "redirect:content";
	}
}
