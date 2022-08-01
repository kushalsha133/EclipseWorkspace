package com.springdemo;

public class SwimCoach implements Coach{
	private HappyFortuneService fortuneService;
	public SwimCoach() {}
	public SwimCoach(HappyFortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run hard 5K";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortunes();
	}
}
