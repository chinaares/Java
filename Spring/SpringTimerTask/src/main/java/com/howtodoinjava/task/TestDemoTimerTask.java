package com.howtodoinjava.task;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemoTimerTask {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:application-config.xml");
		System.out.println("test");
	}
}
