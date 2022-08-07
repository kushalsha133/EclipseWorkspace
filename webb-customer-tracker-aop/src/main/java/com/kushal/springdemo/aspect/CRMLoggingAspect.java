package com.kushal.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	//setup logger
	Logger myLogger = Logger.getLogger(CRMLoggingAspect.class.getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.kushal.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	@Pointcut("execution(* com.kushal.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	@Pointcut("execution(* com.kushal.springdemo.controller.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	
	//add @Before Advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		//display the method being called
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("==> in @Before: calling method : "+method);
		
		//get arguments
		Object[] args = theJoinPoint.getArgs();
		for (Object tempArg : args) {
			myLogger.info("===== >> argument: " +tempArg);
		}
	}
	
	//add @AfterReturning Advice
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===== >> in @After Returning: from method: " + theMethod);
		// display data returned
		myLogger.info("===== >> result: "+ theResult);
	}
}
