package com.springmvcdemo.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Value("#{countryOptions}")  //yehcountryOption naam setkiya tha demo-servlet me for the resource
	private Map<String, String> theCountryOptions;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("theCountryOptions", theCountryOptions);
		return "student-form";
	}
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		System.out.println("first name= "+theStudent.getFirstName());
		System.out.println("Last name= "+theStudent.getLastName());
		return "student-confirmation";
	}
}
