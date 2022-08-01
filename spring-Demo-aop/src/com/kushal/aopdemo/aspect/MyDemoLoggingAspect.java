package com.kushal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advices for logging
	
	@Before("execution(public void addAccount())") //can give wildcards also, like add*() willmatch all starting with add
	//public *<for any return type> add*()
	public void beforeAddAccountAdvice() {
		System.out.println("==> Executing @Before advice on AddAccount execution");
	}
	
	@Before("execution(public void add*())") //can give wildcards also, like add*() willmatch all starting with add
	//public * add*() OR * add*()
	public void beforeAddAdvice() {
		System.out.println("==> Executing @Before advice on all Add* execution");
	}
	
	@Before("execution(public void com.kushal.aopdemo.dao.AccountDAO.addAccount())") //can give wildcards also, like add*() willmatch all starting with add
	//public * add*()
	public void beforeAddAccountAdvice1() {
		System.out.println("==> Executing @Before advice only on AccountDAO.AddAccount execution");
	}
}
