package com.kushal.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Around("execution(* com.kushal.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		//print our method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n==> Executing @Around on Method : "+method);

		long begin = System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end-begin;
		myLogger.info("\n==> Duration: "+duration);
		//
		return result;
	}
	
	
	
	@After("execution(* com.kushal.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		//print method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n==> Executing @After (finally) on Method : "+method);

	}



	@AfterThrowing(
			pointcut="execution(* com.kushal.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc"
			)
	public void afterThrowingAccountAdviceException(JoinPoint theJoinPoint, Throwable theExc) {
		//print method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n==> Executing @AfterThrowing on Method : "+method);

		myLogger.info("\n==> The Exception is: "+theExc);
	}


	//add new advice for After returning
	@AfterReturning(pointcut="execution(* com.kushal.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result") //the value being returned is saved in this variable
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//print method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n==> Executing @AfterReturning on Method : "+method);
		//print out the results of method call
		myLogger.info("\n==> Result is : "+result);

		//postProcess the data
		convertAccountNamesToUpperName(result);
	}

	private void convertAccountNamesToUpperName(List<Account> result) {
		// TODO Auto-generated method stub
		for(Account acc: result) {
			String lvl = acc.getLevel();
			acc.setLevel(lvl.toUpperCase());
		}
	}

	//==============
	@Before("com.kushal.aopdemo.aspect.AOPExpressions.forDAONoGetterSetter()")
	public void beforeAddAccountAdvice6(JoinPoint theJoinPoint) {
		myLogger.info("==> Executing @Before advice on any method of any class under dao package, but no getter and Setter");

		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method Signature ==> " + methodSig);
		//display the method arguments 
		//Get args
		Object[] args = theJoinPoint.getArgs();
		for(Object arg : args) {
			myLogger.info("Argument => "+arg.toString());

			if(arg instanceof Account) {
				//downcast and print Account Specific Stuff
				Account theAccount = (Account) arg;
				myLogger.info("Account Name => "+theAccount.getName());
				myLogger.info("Account Level => "+theAccount.getLevel());
			}
		}
	}	
}
