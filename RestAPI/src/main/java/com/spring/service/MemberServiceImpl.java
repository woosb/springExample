package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.MemberDao;
import com.spring.dto.MemberDto;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao dao;
	
	@Override
	public int register(MemberDto dto) {
		return dao.register(dto);
	}

	@Override
	public int login(MemberDto dto) {
		MemberDto user = dao.login(dto);
		if(user == null) {
			log.info("id not exist");
			return -1;
		}else {
			if( user.getPw().equals(dto.getPw()) ) {
				log.info("login success");
				return 1;
			}else {
				log.info("password error");
				return 0;
			}
		}
	}
}
