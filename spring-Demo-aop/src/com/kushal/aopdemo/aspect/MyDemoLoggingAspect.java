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
	
	@Before("execution(* add*())") //can give wildcards also, like add*() willmatch all starting with add
	//public * add*()
	public void beforeAddAccountAdvice2() {
		System.out.println("==> Executing @Before advice any add* method with any access specifier and return type");
	}
	
	@Before("execution(* add*(com.kushal.aopdemo.Account))") //can give wildcards also, like add*() willmatch all starting with add
	//public * add*()
	public void beforeAddAccountAdvice3() {
		System.out.println("==> Executing @Before advice any add* method accepting Account parameter");
	}
	
	@Before("execution(* add*(com.kushal.aopdemo.Account, ..))") //can give wildcards also, like add*() willmatch all starting with add
	//public * add*()
	public void beforeAddAccountAdvice4() {
		System.out.println("==> Executing @Before advice any add* method accepting Account parameter followed by any number of arguments");
	}
	
	@Before("execution(* add*(..))") //can give wildcards also, like add*() willmatch all starting with add
	//public * add*()
	public void beforeAddAccountAdvice5() {
		System.out.println("==> Executing @Before advice any add* method accepting any number of arguments");
	}
	
	@Before("execution(* com.kushal.aopdemo.dao.*.*(..))") //star1 is ay return type, star2 is any class under that package, thar3 is any function in that class
	//public * add*()
	public void beforeAddAccountAdvice6() {
		System.out.println("==> Executing @Before advice on any method ofany class under dao package");
	}
}
