package com.spring.root.schedulconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MyScheduler {
	@Scheduled(cron = "10 * * * * *")
	public void testSchedul() {
		System.out.println("10초에 한번씩");
	}
	@Scheduled(cron = "0-59 * * * * *")
	public void testSchedul2() {
		System.out.println("매초에 한번씩");
	}
}
