package com.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dao.MemberDAO;
import com.spring.dto.UserLogDTO;

import lombok.extern.log4j.Log4j;

@Controller
@EnableScheduling
@Configuration
@Log4j
public class MainController {
	
	@Autowired
	MemberDAO dao;
	
	@GetMapping(value="/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/common/error")
	public void error() {
		
	}

	int[] countLogin = {0,0,0,0,0,0};
	@PostMapping("/common/getData")
	@ResponseBody
	public int[] getData() {
		return countLogin;
	}
	
	@Scheduled(cron = "10 * * * * *")
	public int[] getLogList() {
		for(int i = 0; i < countLogin.length; i++) {
			countLogin[i] = 0;
		}
		String mm = "0";
		Date date = new Date();
		SimpleDateFormat sdfm = new SimpleDateFormat("mm");
		mm = sdfm.format(date);
		log.info("스케줄러 작동 "+ mm + " 분 로그인 기록");
		
		List<UserLogDTO> list = dao.getLog();
		
		List<Integer> secs = dao.getSecWithMin(mm);	
		for(int s : secs) {
			countLogin[s/10] ++;
		}
		for(int i = 0; i < countLogin.length; i++) {
			log.info(countLogin[i]);
		}
		return countLogin;
	}
}
