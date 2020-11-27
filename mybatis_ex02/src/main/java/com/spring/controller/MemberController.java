package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.dto.MemberDTO;
import com.spring.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/index")
	public void index() {
		
	}
	
	@GetMapping("/insertview")
	public void insertview() {
		
	}
	
	@PostMapping("/insert")
	public String insert(MemberDTO dto) {
		service.insertMember(dto);
		return "redirect:index";
	}
	
	@GetMapping("/memberview")
	public void memberview(Model model) {
		model.addAttribute("member", service.memberview());
	}
}
