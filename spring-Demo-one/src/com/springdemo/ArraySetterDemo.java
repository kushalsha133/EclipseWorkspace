package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArraySetterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Load Spring Config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from container
		SwimCoach theCoach = context.getBean("MySwimCoach", SwimCoach.class);
		//call methods on bean
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		//close context
		context.close();
	}

}
