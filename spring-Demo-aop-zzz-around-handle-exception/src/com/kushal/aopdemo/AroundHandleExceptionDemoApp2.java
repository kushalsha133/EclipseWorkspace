	package com.kushal.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kushal.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp2 {
	public static void main(String[] args) {
		
		Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp2.class.getName());
		// Now we are changing sysout to Mylogger.info
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from the spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info("\n Main Program: Around Demo App");
		myLogger.info("Calling Get Fortune");
		boolean tripWire=true;
		
		String data = null;
		try {
			data = theFortuneService.getFortune(tripWire);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			myLogger.info(e.getMessage());
		}
		
		myLogger.info("\n My Fortune: "+data);
		myLogger.info("Finished\n");
//		close
		context.close();
	}
}
