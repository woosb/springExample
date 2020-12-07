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

import lombok.extern.log4j.Log4j;

@Component
@Aspect
@EnableAspectJAutoProxy
@Log4j
public class AOPConfig {
	@Autowired
	MemberDAO dao;
	
	@Before("execution(* com.spring.controller.MemberController.loginChk(..)) && args(dto,..)")
	public void loginLog(JoinPoint joinPoint, MemberDTO dto) {
		String id = dto.getId();
		log.info("login id : " + id); 
		dao.setStartTime(id);
	}

	@Before("execution(* com.spring.controller.MemberController.logout(..)) && args(session)")
	public void logoutLog(JoinPoint joinPoint, HttpSession session) {
		String id = (String)session.getAttribute("userId");
		log.info("logout id : " + id); 
		dao.setEndTime(id);
	}
}
