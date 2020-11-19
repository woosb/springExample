package com.care.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {
//delSession.jsp, makeSession.jsp, resultSession.jsp
	@RequestMapping("makeSession")
	public String makeSession(HttpServletRequest request,
								Model model) {
		model.addAttribute("id","나야나");
		HttpSession session = request.getSession();
		session.setAttribute("id", "홍길동");
		session.setAttribute("age", "20");
		session.setAttribute("addr", "산골");
		return "makeSession";
	}
	@RequestMapping("resultSession")
	public String resultSession() {
		return "resultSession";
	}
	@RequestMapping("delSession")
	public String delSession(HttpSession session) {
		session.removeAttribute("id");
		//session.invalidate();
		return "delSession";
	}
	
}









