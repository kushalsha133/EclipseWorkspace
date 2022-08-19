package com.kushal.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
	public List<Student> loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Poornima", "Sharma"));
		theStudents.add(new Student("Poornima", "Chaudhary"));
		return theStudents;
	}
	
	//define endpoint for /Students
	@GetMapping("/students")
	public List<Student> getStudents(){
		return loadData();
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		return loadData().get(studentId);
	}
	
}
