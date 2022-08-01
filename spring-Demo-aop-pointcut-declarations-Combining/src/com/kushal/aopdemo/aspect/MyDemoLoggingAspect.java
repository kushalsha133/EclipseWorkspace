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
	
	//pointcut for getters
	@Pointcut("execution(* com.kushal.aopdemo.dao.*.get*(..))")
	private void getters() {}
	
	//pointcut for setters
	@Pointcut("execution(* com.kushal.aopdemo.dao.*.set*(..))")
	private void setters() {}
	
	//create pointcut for not getter/setter
	@Pointcut("forDAOPackage() && !(getters() || setters())")
	private void forDAONoGetterSetter() {}
	
	@Before("forDAONoGetterSetter()")
	public void beforeAddAccountAdvice6() {
		System.out.println("==> Executing @Before advice on any method of any class under dao package,but no getter and Setter");
	}
	
	@Before("forDAOPackage()")
	public void performingApiAnalytics() {
		System.out.println("==> performing API ANalytics");
	}
}
