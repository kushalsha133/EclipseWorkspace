package com.kushal.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kushal.aopdemo.dao.AccountDAO;
import com.kushal.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		// call the business method
		Account acc = new Account();
		acc.setLevel("21");
		acc.setName("DankKush");
		theAccountDAO.addAccount1(acc);
		theAccountDAO.addAccount2(acc, true);
		theAccountDAO.addAccount();
		theAccountDAO.addSillyMember();
		membershipDAO.addAccount();
		membershipDAO.goToSleep();
		theAccountDAO.setName("Kushal");
		theAccountDAO.setServiceCode("Silver");
		String name = theAccountDAO.getName();
		String service = theAccountDAO.getServiceCode();
//		//close
		context.close();
	}
}
