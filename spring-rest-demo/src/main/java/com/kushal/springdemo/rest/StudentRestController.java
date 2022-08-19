package com.kushal.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kushal.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	List<Student> theStudents;
	
	//define @PostConstruct to load the student data  only once
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Poornima", "Sharma"));
		theStudents.add(new Student("Poornima", "Chaudhary"));
	}
	
	//define endpoint for /Students
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		//adding exception Support
		if( (studentId >= theStudents.size()) || (studentId<0) ){
			throw new StudentNotFoundException("Studentis is not found for id - "+studentId);
		}
		return theStudents.get(studentId);
	}
	
	
	//Adding an exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		//Creating a StdentErrorResponse object
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//Return RespinseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//exception handler to cath any exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//Return RespinseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
