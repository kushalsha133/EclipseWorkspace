package com.kushal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
	@Before("com.kushal.aopdemo.aspect.AOPExpressions.forDAONoGetterSetter()")
	public void loggingToCloud() {
		System.out.println("==> Logging to Cloud, no Getter/Setter");
	}
}
