package com.care.controller;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginGet() {
		return "login/login";
	}
	@PostMapping("chkUser")
	public String chkUser(@RequestParam("id") String id,
						@RequestParam("pwd") String pwd,
						HttpSession session) {
		String sid="1",spwd="1", nickName="홍길동";
		if(sid.equals(id) && spwd.equals(pwd) ) {
			session.setAttribute("loginUser", nickName);
			return "login/main";
		}else {
			return "redirect:login";
		}
	}
	@GetMapping("logout")
	public String logout(HttpSession session) {
		/*
String message = "<script>alert("로그아웃 되었습니다");"+
					"location.href="login";</script>";
HttpHeaders responseHeader = new HttpHeaders();
responseHeader.add("Content-Type", "text/html; charset=utf-8");
ResponseEntity resEnt = 
new ResponseEntity(message,responseHeader,HttpStatus.CREATED );
		 */
		session.invalidate();
		return "login/logout";
	}
}














