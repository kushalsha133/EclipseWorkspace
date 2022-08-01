package com.kushal.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.kushal.aopdemo.Account;

@Component
public class AccountDAO {
	public void addAccount() {
		System.out.println(getClass()+" :Adding Account");
	}
	public void addSillyMember() {
		System.out.println(getClass()+" :Doing silly");
	}
	public void addAccount1(Account theAccount) {
		System.out.println(getClass()+" :Adding Account 1");
	}
	
	public void addAccount2(Account theAccount, boolean vip) {
		System.out.println(getClass()+" :Adding Account 1");
	}
}
