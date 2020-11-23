package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.dao.TestDAO;

@Service
public class MyServiceImpleB implements MyService{
	public MyServiceImpleB() {
		System.out.println("MyServiceImpleB 생성자 실행");
	}
	
	@Autowired
	@Qualifier("testDAO")
	private TestDAO dao;
	
	@Override
	public void execute() {
//		dao = new TestDAO();
		System.out.println("dao : " + dao);
		dao.test02();
	}
}
