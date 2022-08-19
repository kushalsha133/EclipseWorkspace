package com.kushal.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kushal.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	//define endpoint for /Students
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Poornima", "Sharma"));
		theStudents.add(new Student("Poornima", "Chaudhary"));
		return theStudents;
	}
}
