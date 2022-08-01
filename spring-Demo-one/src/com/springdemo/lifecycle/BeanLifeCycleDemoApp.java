package com.springdemo.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanLifeCycleApplicationContext.xml");
		Coach theCoach = context.getBean("myCoach", TrackCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		context.close();
	}
}
