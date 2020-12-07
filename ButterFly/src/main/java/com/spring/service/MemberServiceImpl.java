package com.spring.service;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberDTO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;

	@Override
	public int login(MemberDTO dto) {
		MemberDTO user = dao.login(dto);
		if(user != null) {
			if( user.getPw().equals(dto.getPw()) )
				return 1;
			else
				return 0;
		}
		return -1;
	}
	
	@Override
	public int join(MemberDTO dto) {
		int reuslt = dao.join(dto);
		return reuslt;
	}

	@Override
	public List<MemberDTO> memberInfo() {
		return dao.memberInfo();
	}

	@Override
	public void memberList(Model model) {
		model.addAttribute("list", dao.getLog());
	}

	@Override
	public int modifyPw(MemberDTO dto) {
		return dao.modifyPw(dto);
	}
	
}
