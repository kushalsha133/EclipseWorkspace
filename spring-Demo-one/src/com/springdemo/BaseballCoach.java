package com.springdemo;

public class BaseballCoach implements Coach{
	//private field for dependency
	private FortuneService fortuneService;
	// defining constructor for dependency
	public BaseballCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes o batting practice";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return this.fortuneService.getFortune();
	}
}
