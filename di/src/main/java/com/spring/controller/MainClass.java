package com.spring.controller;

public class MainClass {
	public static void main(String[] args) {
		STBean stBean = new STBean();
		Student st = new Student();
		
		String name = "홍길동";
		int age = 20;
		
		stBean.setName(name);
		stBean.setAge(age);
		stBean.setSt(st);
		
		st.namePrint(name);
		st.agePrint(age);
	}
}
