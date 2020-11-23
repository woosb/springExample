package com.spring.dao;

import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	public TestDAO() {
		System.out.println("dao 생성자 실행");
	}
	public void test() {
		System.out.println("dao test 실행");
	}
	public void test02() {
		System.out.println("dao test02 실행");
	}
}
