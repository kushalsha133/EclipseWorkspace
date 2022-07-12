package com.springmvcdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class customerController {

	//Add initBinder to trim all the strings of web results 
	//Remove leading and trailing whitespaces
	//and resolve validation issue 
	@InitBinder
	public void initBinder(WebDataBinder wdb) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		wdb.registerCustomEditor(String.class, ste);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult result) {
		if(result.hasErrors()){
			return "customer-form";
		}
		return "customer-confirmation";
	}
}
