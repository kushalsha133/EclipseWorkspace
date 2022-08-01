package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		//read spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		// call a method in bean
		System.out.println(theCoach.GetDailyWorkout());
		System.out.println(theCoach.GetDailyFortune());
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTname());
		//close the context
		context.close();
		
	}

}
