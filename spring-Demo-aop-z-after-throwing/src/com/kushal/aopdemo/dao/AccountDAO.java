package com.kushal.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

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
		
	public void addAccount(Account theAccount, boolean vip) {
		System.out.println(getClass()+" :Adding Account 1");
	}
	
	//add a new method 
	public List<Account> findAccounts(boolean b){
		if(b==true) {
			throw new RuntimeException("Explicit Exception");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		//some temp accounts
		Account temp1 = new Account("Kush0","Gold");
		Account temp2 = new Account("Kush1","Silver");
		Account temp3 = new Account("Kush2","bronze");
		myAccounts.add(temp3);
		myAccounts.add(temp2);
		myAccounts.add(temp1);
		return myAccounts;
	}
}
