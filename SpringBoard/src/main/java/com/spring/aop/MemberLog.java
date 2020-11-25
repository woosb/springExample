package com.spring.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberDTO;
import com.spring.dto.MemberLogDTO;

@Aspect
@Component
public class MemberLog {
	String id;
	
	@Autowired
	MemberDAO dao;
	
	@Before("execution(* com.spring.controller.MemberController.login_(..)) && args(dto,..)")
	public void loginLog(JoinPoint joinPoint, MemberDTO dto) {
		System.out.println("login Log 실행됨");
	
		String starttime = getDate();
		
		MemberLogDTO log = new MemberLogDTO();
		log.setStarttime(starttime);
		log.setId(dto.getId());
		
		dao.loginLog(log);
	}

	@Before("execution(* com.spring.controller.MemberController.logout(..)) && args(session)")
	public void logoutLog(JoinPoint joinPoint, HttpSession session) {
		System.out.println("logout Log 실행됨");
		
		String userId = (String)session.getAttribute("id");
		MemberLogDTO dto = dao.getLoginMember(userId);
		String starttime = dto.getStarttime();
		String endtime = getDate();
		
		int resulttime = getResultTime(starttime, endtime);
		
		MemberLogDTO log = new MemberLogDTO();
		log.setEndtime(endtime);
		log.setId(userId);
		log.setResulttime(resulttime);
		
		dao.logoutLog(log);
	}
	
	public String getDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		
		String currentTime = sdf.format(date);
		
		return currentTime;
	}
	
	public int getResultTime(String start, String end) {
		String stime = start.substring(14, 22);
		String etime = end.substring(14, 22);
		
		String s[] = stime.split(":");
		String e[] = etime.split(":");
		
		int sum = 0;
		int cnt = 2;
		for(String a : e) {
			int time = Integer.parseInt(a);
			sum += time * Math.pow(60, cnt--);
		}
		
		cnt=2;
		for(String a : s) {
			int time = Integer.parseInt(a);
			sum -= time * Math.pow(60, cnt--);
		}

		System.out.println(sum/3600 + " 시간");
		return sum;
	}
}
