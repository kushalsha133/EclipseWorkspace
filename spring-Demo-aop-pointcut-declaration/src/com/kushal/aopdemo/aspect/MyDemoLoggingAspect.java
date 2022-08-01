package com.kushal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//thisi our pointcut expression,which we can use anyplace
	@Pointcut("execution(* com.kushal.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Before("forDAOPackage()")
	public void beforeAddAccountAdvice6() {
		System.out.println("==> Executing @Before advice on any method of any class under dao package");
	}
	
	@Before("forDAOPackage()")
	public void performingApiAnalytics() {
		System.out.println("==> Executing @Before advice on any method of any class under dao package");
		System.out.println("==> performing API ANalytics");
	}
}
