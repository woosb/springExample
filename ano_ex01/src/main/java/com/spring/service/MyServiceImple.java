package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring.dao.TestDAO;

@Service
public class MyServiceImple implements MyService{
	public MyServiceImple() {
		System.out.println("MyServiceImple 생성자 실행");
	}
	
	@Autowired
//	@Qualifier("testDAO")
	private TestDAO dao;
	
	@Override
	public void execute() {
//		dao = new TestDAO();
		System.out.println("dao : " + dao);
		dao.test();
	}
}
