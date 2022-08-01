package com.kushal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	
	@Before("com.kushal.aopdemo.aspect.AOPExpressions.forDAONoGetterSetter()")
	public void beforeAddAccountAdvice6() {
		System.out.println("==> Executing @Before advice on any method of any class under dao package, but no getter and Setter");
	}	
	
}
