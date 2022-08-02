package com.kushal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	@Before("com.kushal.aopdemo.aspect.AOPExpressions.forDAOPackage()")
	public void performingApiAnalytics() {
		System.out.println("==> performing API ANalytics");
	}
}
