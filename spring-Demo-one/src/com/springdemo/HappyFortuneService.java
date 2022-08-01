package com.springdemo;

import java.util.Random;

public class HappyFortuneService implements FortuneService {
	private String[] fortunes;
	Random rand = new Random();
	public String getFortunes() {
		return fortunes[rand.nextInt(3)];
	}

	public void setFortunes(String[] fortunes) {
		System.out.println("Inside set fortunes");
		this.fortunes = fortunes;
	}

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Today is your lucky day";
	}

}
