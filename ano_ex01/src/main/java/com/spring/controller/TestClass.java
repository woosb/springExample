package com.spring.controller;

import org.springframework.stereotype.Component;

@Component
public class TestClass {
	public TestClass() {
		System.out.println("component TestClass 생성자 입니다.");
	}
	
	public void print() {
		System.out.println("TestClass.print() 메소드 입니다.");
	}
}
