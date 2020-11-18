package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member", method=RequestMethod.GET)
public class MyController {
	
	@RequestMapping("/index")
	public void index(Model model) {
		model.addAttribute("index", "기본페이지 입니다.");
	}
	@RequestMapping("/login")
	public void login(Model model) {
		model.addAttribute("login", "로그인 페이지 입니다.");
	}
	@RequestMapping("/logout")
	public ModelAndView logout(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("logout", "로그아웃 페이지 입니다.");
		mv.setViewName("member/logout");
		return mv;
	}
}
