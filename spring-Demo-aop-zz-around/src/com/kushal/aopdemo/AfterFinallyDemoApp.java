	package com.kushal.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kushal.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {
	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		//call method to find account
		List<Account> theAccounts = null;
		
		try {
			boolean tripWire=false;
			theAccounts = theAccountDAO.findAccounts(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("\n\nMainProgram Exception: "+e+"\n");
		}
		System.out.println("\n\nMain program: After Throwing Demo App");
		System.out.println("---");
		
		System.out.println("The Accounts: "+theAccounts+"\n\n");
		
		
		
//		//close
		context.close();
	}
}
