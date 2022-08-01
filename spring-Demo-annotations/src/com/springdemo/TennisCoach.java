package com.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("BichCoach")//here we are giving bean id explicitly ifnot provided bean id is Class name in camel case
@Component
//@Scope("prototype") //isko singleton karke(default is also singleton) bean scope vali class run karke dekho
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService") //can be used in any injection method used to tell the compiler which class to link if there are multiple options available for the type FortuneService
	private FortuneService fortuneService;
	
//	@Autowired 
//	public TennisCoach(FortuneService fortuneService) {
//		super();
//		this.fortuneService = fortuneService;
//	}
	public TennisCoach() {
		System.out.println("Inside default constructor");
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach :do my startup stuff");
	}
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach : so my cleanup stuff");
	}
	
	
	
//	@Autowired  //this can be done with any method name not only setter method as long the arguments match the class type
//	public void setFortuneService(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	@Override
	public String GetDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice your backhand";
	}

	@Override
	public String GetDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortuneService();
	}

}
