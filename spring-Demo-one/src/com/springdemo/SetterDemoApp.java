/**
 * 
 */
package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kusha
 *
 */
public class SetterDemoApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Load Spring Config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from cntainer
		CricketCoach theCoach = context.getBean("MyCricketCoach", CricketCoach.class);
		//call methods on bean
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		
		System.out.println("team: "+theCoach.getTeam());
		System.out.println(theCoach.getEmailAddress());
		//close context
		context.close();
	}

}
