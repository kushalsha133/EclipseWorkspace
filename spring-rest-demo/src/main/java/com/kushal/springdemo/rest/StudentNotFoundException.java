package com.kushal.springdemo.rest;

public class StudentNotFoundException extends RuntimeException{

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
