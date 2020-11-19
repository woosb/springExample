package com.care.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CookieController {
	@RequestMapping("cookie")
	public String myCookie(HttpServletResponse response,
			@CookieValue(value="myCookie", required=false) Cookie cook,
			Model model,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				System.out.println(c.getName() + ":" + c.getValue());
			}
		}
		/*
		System.out.println("cook : "+cook);
		if(cook == null) {
			Cookie cookie = new Cookie("myCookie","쿠키생성");
			cookie.setMaxAge(10);
			response.addCookie(cookie);
			return "cookie";
		}
		model.addAttribute("cook",cook.getValue());
		*/
		if(cook != null)
			model.addAttribute("cook",cook.getValue());	
		return "cookie";
	}
	@RequestMapping("popup")
	public String popup() {
		return "popup";
	}
	@RequestMapping("cookieChk")
	public ResponseEntity cookieChk(HttpServletResponse response) {
		Cookie cook = new Cookie("myCookie","나의쿠키");
		cook.setMaxAge(10);
		/*
		 * 쿠키의 path 속성 및 속성에 따른 쿠키 전송 규칙
		 * 쿠키의 path 속성을 이용하면 웹서버의 특정 URL에 대해서만 쿠키를 전송할 수 있습니다. 
		 * path 속성은 웹서버의 디렉터리 단위로 지정이 가능하며, 디렉터리를 지정하면 지정한 해당 디렉터와 그 하위 경로에만 쿠키가 전송됩니다. 
		 * 디렉터리 단위라는것은 URL 경로상에 / (슬래쉬)로 구분되어지는 단위를 말합니다.
		 * */
		cook.setPath("/");
		response.addCookie(cook);
		String message = "<script>window.close()</script>";
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.add("Content-Type", "text/html; charset=utf-8");
		ResponseEntity resEnt = 
		new ResponseEntity(message,responseHeader,HttpStatus.CREATED );
		return resEnt;
	}
}

















