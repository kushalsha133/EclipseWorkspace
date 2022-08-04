	package com.kushal.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kushal.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from the spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("\n Main Program: Around Demo App");
		System.out.println("Calling Get Fortune");
		String data = theFortuneService.getFortune();
		System.out.println("\n My Fortune: "+data);
		System.out.println("Finished\n");
//		close
		context.close();
	}
}
