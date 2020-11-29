package com.spring.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dao.MemberDao;
import com.spring.dto.MemberDto;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/database/jdbc-config.xml"})
public class MemberDaoTests {
	
	@Autowired
	MemberDao dao;
	
	@Test
	public void registser() throws Exception{
		MemberDto dto = new MemberDto();
		dto.setId("admin");
		dto.setPw("password");
		dto.setAddr("addr"); 
		dao.delete(dto);
		int result = dao.register(dto);
		log.info("register result : " + result);
	}
	
	@Test
	public void login() {
		MemberDto dto = new MemberDto();
		dto.setId("admin");
		dto.setPw("password");
		dto.setAddr("addr"); 
		MemberDto user = dao.login(dto);
		log.info("login result : " + user);
	}
}
