package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		//read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		// call a method in bean
		System.out.println(theCoach.GetDailyWorkout());
		System.out.println(theCoach.GetDailyFortune());
		//close the context
		context.close();
		
	}

}
