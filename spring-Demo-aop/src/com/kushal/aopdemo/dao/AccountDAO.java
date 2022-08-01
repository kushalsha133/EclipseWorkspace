package com.kushal.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass()+" :Adding Account");
	}
	public void addSillyMember() {
		System.out.println(getClass()+" :Doing silly");
	}
}
