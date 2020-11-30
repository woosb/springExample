package com.spring.root.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	JavaMailSender mailSender;
	
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
	
	public void auth(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userid = "woosb";
		String userkey = rand();
		session.setAttribute(userid, userkey);
		String body = "<h2>안녕하세요</h2>"
				+ "<p>인증하기 버튼을 누르면 로그인이 됩니다.</p> "
				+ "<a href='http://localhost:8181/"
				+ request.getContextPath()+ "auth_check?userid="
				+userid+"&userkey="+userkey+"'>인증하기</a>";
		sendMail("wooyh0115@naver.com", "이메일 인증 입니다.",body);
	}
	
	private String rand() {
		Random ran = new Random();
		String str = "";
		int num;
		while(str.length() != 20){
			num = ran.nextInt(75) + 48;
			//숫자 || 대문자 || 소문자
			if( (num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >=97 && num <= 122) ) {
				str += (char)num;
			}else {
				continue;
			}
		}
		return str;
	}
}
