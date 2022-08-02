package com.kushal.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kushal.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {
	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		//call method to find account
		List<Account> theAccounts = theAccountDAO.findAccounts();
		System.out.println("\n\nMain program: After Returning Demo App");
		System.out.println("---");
		
		System.out.println("The Accounts: "+theAccounts+"\n\n");
		
		
		
//		//close
		context.close();
	}
}
