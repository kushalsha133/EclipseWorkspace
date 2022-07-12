package com.springmvcdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	//need a controller method to show the form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	//need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//Add a controller method to read form data and add a model
	@RequestMapping("/processformVersion2")
	public String letsShoutDude(HttpServletRequest req, Model model) {
		String name = req.getParameter("studentName");
		name = name.toUpperCase();
		String result = "yo "+name;
		model.addAttribute("message", result);
		return "helloworld"; 
	}
	
	@RequestMapping("/processformVersion3")
	public String processformVersionthree(@RequestParam("studentName") String name, Model model) {
		name = name.toUpperCase();
		String result = "hey my friend "+name;
		model.addAttribute("message", result);
		return "helloworld"; 
	}
}
