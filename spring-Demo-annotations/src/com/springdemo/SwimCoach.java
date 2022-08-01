package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String tname;
	
	public String getEmail() {
		return email;
	}
	public String getTname() {
		return tname;
	}
	public SwimCoach(FortuneService fortuneService) {
		// TODO Auto-generated constructor stub
		this.fortuneService = fortuneService;
	}
	@Override
	public String GetDailyWorkout() {
		// TODO Auto-generated method stub
		return "swim 1000m for warmup";
	}

	@Override
	public String GetDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortuneService();
	}

}
