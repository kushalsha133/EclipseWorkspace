package com.kushal.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(getClass() +" : Doing Stuff");
	}
	
	public void goToSleep() {
		System.out.println(getClass()+" : Go to Sleep");
	}
}
