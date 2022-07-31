package com.kushal.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kushal.springdemo.dao.CustomerDAO;
import com.kushal.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the customer Dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		//get Customer from DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		//add the Customers to the Model
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
	}
}
