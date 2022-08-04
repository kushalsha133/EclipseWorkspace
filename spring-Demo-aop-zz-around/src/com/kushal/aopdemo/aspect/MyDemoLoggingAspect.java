package com.kushal.aopdemo.aspect;

import java.util.List;



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

	@Around("execution(* com.kushal.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		//print our method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n==> Executing @Around on Method : "+method);

		long begin = System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		long duration = end-begin;
		System.out.println("\n==> Duration: "+duration);
		//
		return result;
	}
	
	
	
	@After("execution(* com.kushal.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		//print method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n==> Executing @After (finally) on Method : "+method);

	}



	@AfterThrowing(
			pointcut="execution(* com.kushal.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc"
			)
	public void afterThrowingAccountAdviceException(JoinPoint theJoinPoint, Throwable theExc) {
		//print method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n==> Executing @AfterThrowing on Method : "+method);

		System.out.println("\n==> The Exception is: "+theExc);
	}


	//add new advice for After returning
	@AfterReturning(pointcut="execution(* com.kushal.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result") //the value being returned is saved in this variable
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//print method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n==> Executing @AfterReturning on Method : "+method);
		//print out the results of method call
		System.out.println("\n==> Result is : "+result);

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
