package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		//read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//get the bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		// call a method in bean
		System.out.println(theCoach.GetDailyWorkout());
		System.out.println(theCoach.GetDailyFortune());
		//close the context
		context.close();
		
	}

}
