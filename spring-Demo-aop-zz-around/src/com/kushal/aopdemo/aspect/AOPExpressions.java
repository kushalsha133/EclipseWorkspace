package com.kushal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {
	//this is our pointcut expression,which we can use anyplace
	@Pointcut("execution(* com.kushal.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}

	//pointcut for getters
	@Pointcut("execution(* com.kushal.aopdemo.dao.*.get*(..))")
	public void getters() {}

	//pointcut for setters
	@Pointcut("execution(* com.kushal.aopdemo.dao.*.set*(..))")
	public void setters() {}

	//create pointcut for not getter/setter
	@Pointcut("forDAOPackage() && !(getters() || setters())")
	public void forDAONoGetterSetter() {}

}
//Order Annotation will order which Advice should run in which order, value can range from Integer.MIN_VALUE to
//Integer.MAX_VALUE, is not really a numbered ordering, but hierarchial. Suppose there are three aspects ordered
//1, 20, 54 they will run in increasing order, can be negative also. And if there is same order given for two 
//aspects say 1, 4, 6, 6, 10. these two aspects with order 6 will run in random order but others will run in defined order

