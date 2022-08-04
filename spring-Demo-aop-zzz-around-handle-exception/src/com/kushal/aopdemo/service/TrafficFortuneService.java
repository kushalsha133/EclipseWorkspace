package com.kushal.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Expect Heavy Traffic This Morning";
	}

	public String getFortune(boolean tripWire) {
		// TODO Auto-generated method stub
		if(tripWire) {
			throw new RuntimeException("Major Incident! Highway is closed");
		}

		//return "Expect Heavy Traffic This Morning";
		return getFortune();
	}
}
