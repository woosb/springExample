package com.spring.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping(value="login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping(value="success")
	public String success(@RequestParam("code") String code, HttpSession session) {
		System.out.println("code : " + code);
		System.out.println("로그인 성공 success 연결 되었습니다.");
		GetKakao kakao = new GetKakao();
		String accessToken = kakao.getAccessToken(code);
		HashMap<String, Object> userInfo = kakao.getUserInfo(accessToken);
		session.setAttribute("userId", userInfo.get("nickname"));
		return "success";
	}
	
	@RequestMapping(value="/logout")
   public ResponseEntity logout(HttpSession session) {
       session.removeAttribute("userId");
       String str = "<script>alert('로그아웃 되었습니다');";
       str+="location.href='https://accounts.kakao.com/weblogin/sso_logout"
             + "?continue=http://localhost:8181/loginForm'</script>";
       ResponseEntity resEnt=null;
       HttpHeaders responseHeaders = new HttpHeaders();
       responseHeaders.add("Content-Type", "text/html; charset=utf-8");
       resEnt = new ResponseEntity(str, responseHeaders, HttpStatus.CREATED);
       return resEnt;
   }

}
