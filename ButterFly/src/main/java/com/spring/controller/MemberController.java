package com.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dto.MemberDTO;
import com.spring.service.MailService;
import com.spring.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping(value="/member")
@Log4j
public class MemberController {	
	
	@Autowired
	MemberService service;
	@Autowired
	MailService mailService;
	
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
	
	@GetMapping(value="password")
	public void password() {
		
	}
	
	@PostMapping(value="password")
	public void passwordChk(String id, String email, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		mailService.authCheck(id, email, request, response, session);
	}
	
	@GetMapping(value="checkMail")
	public String checkMail(@RequestParam("id") String id, @RequestParam("userKey") String userKey, HttpSession session) {
		String key = (String)session.getAttribute(id);
		if(key.equals(userKey)) {
			return "redirect:/member/modifyPw?id="+id;
		}else {
			return "redirect:/common/error";
		}
	}
	
	@GetMapping(value="modifyPw")
	public void modifyPw(@RequestParam("id") String id, Model model) {
		model.addAttribute("id", id);
	}
	
	@PostMapping(value="modifyPw")
	public void modifyPw(MemberDTO dto) {
		int result = service.modifyPw(dto);
	}
}