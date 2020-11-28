package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dto.Criteria;
import com.spring.dto.MemberDTO;
import com.spring.dto.PageDTO;
import com.spring.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(MemberDTO dto, Model model) {
		int result = service.register(dto);
		System.out.println(result);
		if(result == 1) {
			return "redirect:/";
		}else {
			model.addAttribute(result);
			return "redirect:/member/register";
		}
	}	

	@GetMapping("/login")
	public void login() {
		
	}
	
	@PostMapping("/login")
	public void login_(MemberDTO dto, HttpServletRequest request, Model model) {
		int result = service.login(dto, request);
		if(result == 1) {
			model.addAttribute("login","success");
		}else {
			model.addAttribute("login", "fail");
		}
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("list")
	public void memberList(Model model) {
		List<MemberDTO> list =  service.getMemberList();
		model.addAttribute("list", list);
	}
	
	@GetMapping("detail")
	public void memberDetail(Model model, @RequestParam("id") String id) {
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		model.addAttribute("dto",service.getMember(dto));
	}
	
	@GetMapping("log")
	public void memberLog(Model model, Criteria cri) {
		int total = service.getLogCount();
		
		PageDTO pageMaker = new PageDTO(cri, total);
		model.addAttribute("pageMaker", pageMaker);
		
		model.addAttribute("log", service.getLog(cri));
	}
}
