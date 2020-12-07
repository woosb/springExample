package com.spring.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MailServiceImpl implements MailService{
	
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void authCheck(String id, String email, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String userKey = rand();
		session.setAttribute(id, userKey);
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<h1>이메일 인증</h1>");
		sb.append("<a href='http://localhost:8181/member/checkMail?id="+id+"&userKey="+userKey+"'"+">인증하기</a>");
		String str = sb.toString();
		sendMail(email, "이메일 인증", str);
	}
	
	public String rand() {
		//65-90
		//97-122
		//48-57
		StringBuffer key = new StringBuffer();
		while( key.length() < 20 ) {
			int num = (int)(Math.random()*122+48);
			if(num >= 65 && num <= 90 || num >= 97 && num <= 122 || num >= 48 && num <= 57) {
				key.append((char)num);
			}
		}
		return key.toString();
	}
	
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject(subject);
			messageHelper.setTo(to);
			messageHelper.setText(body, true); //html코드를 텍스트형식이 아니라 실제 html문서형식으로 보낼 수 있다.
			mailSender.send(message);
		}catch(Exception e) {
			e.printStackTrace(); 
		}
	}
}
