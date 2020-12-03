package com.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.MemberDTO;
import com.spring.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {	
	
	@Autowired
	MemberService service;
	
	@GetMapping(value="/login")
	public void login() {
		
	}
	
	@PostMapping(value="/login")
	@ResponseBody
	public int loginChk(MemberDTO dto, HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		int result = service.login(dto);
		if(result == 1) {
			session.setAttribute("userId", id);
		}
		return result;
	}
	
	@GetMapping(value="/join")
	public void join() {
		
	}
	
	@PostMapping(value="/join")
	@ResponseBody
	public int join(Model model, MemberDTO dto) {
		int result = service.join(dto);
		return result;
	}
	
	@GetMapping(value="logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}
	
	@GetMapping(value="memberInfo")
	public void memberInfo(Model model) {
		model.addAttribute("list", service.memberInfo());
	}
	
	@GetMapping(value="memberList")
	public void memberList(Model model) {
		service.memberList(model);
	}
	
}