package com.springdemo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getTeam() {
		return team;
	}
	public void setEmailAddress(String emailAddress) {
		System.out.println("Inside cricket coach email setter");
		this.emailAddress = emailAddress;
	}
	public void setTeam(String team) {
		System.out.println("Inside cricket Coach team setter");
		this.team = team;
	}
	//no arg constructor
	public CricketCoach() {
		System.out.println("Inside cricket Coach no arg constructor");
	}
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside cricket Coach setter");
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15mins";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
