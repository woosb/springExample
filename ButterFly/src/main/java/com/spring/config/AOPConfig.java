package com.spring.config;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberDTO;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AOPConfig {
	@Autowired
	MemberDAO dao;
	
	@Before("execution(* com.spring.controller.MemberController.loginChk(..)) && args(dto,..)")
	public void loginLog(JoinPoint joinPoint, MemberDTO dto) {
		String id = dto.getId();
		dao.setStartTime(id);
	}

	@Before("execution(* com.spring.controller.MemberController.logout(..)) && args(session)")
	public void logoutLog(JoinPoint joinPoint, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		System.out.println("logout : "+id);
		dao.setEndTime(id);
	}

}
