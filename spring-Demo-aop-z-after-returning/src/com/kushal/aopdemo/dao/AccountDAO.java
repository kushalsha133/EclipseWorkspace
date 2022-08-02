package com.kushal.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.kushal.aopdemo.Account;

@Component
public class AccountDAO {
	private String name;
	private String serviceCode;
	
	
	public String getName() {
		System.out.println("in Get name Code");
		return name;
	}
	public void setName(String name) {
		System.out.println("in Set name Code");
		this.name = name;
	}
	public String getServiceCode() {
		System.out.println(" In get service code");
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		System.out.println(" In set service code");
		this.serviceCode = serviceCode;
	}
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
