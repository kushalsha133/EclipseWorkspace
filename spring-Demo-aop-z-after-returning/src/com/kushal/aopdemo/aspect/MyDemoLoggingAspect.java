package com.kushal.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.kushal.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	
	@Before("com.kushal.aopdemo.aspect.AOPExpressions.forDAONoGetterSetter()")
	public void beforeAddAccountAdvice6(JoinPoint theJoinPoint) {
		System.out.println("==> Executing @Before advice on any method of any class under dao package, but no getter and Setter");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method Signature ==> " + methodSig);
		//display the method arguments 
		//Get args
		Object[] args = theJoinPoint.getArgs();
		for(Object arg : args) {
			System.out.println("Argument => "+arg);
			
			if(arg instanceof Account) {
				//downcast and print Account Specific Stuff
				Account theAccount = (Account) arg;
				System.out.println("Account Name => "+theAccount.getName());
				System.out.println("Account Level => "+theAccount.getLevel());
			}
		}
	}	
}
