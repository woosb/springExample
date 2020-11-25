package com.spring.aop_ex01;

public class CoreClass {
	public void corePrint() {
		for(int i = 0; i < 10; i++	) {
			try {
				Thread.sleep(100);
				System.out.println("핵심기능 실행(실제 프로젝트 코드)");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
