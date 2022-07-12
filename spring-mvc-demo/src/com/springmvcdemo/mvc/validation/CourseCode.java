package com.springmvcdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) //will have the businesslogic
@Target( { ElementType.METHOD , ElementType.FIELD}) //setting targets where this will work.
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	//Define Default Code
	public String value() default "LUV";
	//Define Default Error Message
	public String message() default "Must Start with LUV";
	//Define Default groups
	public Class<?>[] groups() default {};	
	//define Default Payloads
	public Class<? extends Payload>[] payload() default {};
}
