package com.springdemo.scopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanScopeApplicationContext.xml");
		Coach theCoach = context.getBean("myCoach", TrackCoach.class);
		Coach alphaCoach = context.getBean("myCoach", TrackCoach.class);
		//checking whether they are the same
		// to test change scope inside context file and see output
		boolean result = (theCoach == alphaCoach);
		System.out.println("Pointing to the same Object:"+result);
		System.out.println("loc of theCoach"+theCoach);
		System.out.println("loc of aplhaCoach"+alphaCoach);
		context.close();
	}
}
