package com.kushal.springdemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kushal.springdemo.entity.Customer;
import com.kushal.springdemo.service.CustomerService;
import com.kushal.springdemo.util.SortUtils;
import com.kushal.springdemo.util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the customer Dao
//	@Autowired
//	private CustomerDAO customerDAO;
	@Autowired
	private CustomerService customerService;
	
//	//@RequestMapping("/")
//	@GetMapping("/list")
//	public String listCustomer(Model theModel) {
//		//get Customer from DAO
//		List<Customer> theCustomers = customerService.getCustomers();
//		//add the Customers to the Model
//		theModel.addAttribute("customers", theCustomers);
//		return "list-customers";
//	}
	
	//adding column sorting 
	@GetMapping("/list")
	public String listCustomers(Model theModel, @RequestParam(required=false) String sort) {
		
		// get customers from the service
		List<Customer> theCustomers = null;
		
		// check for sort field
		if (sort != null) {
			int theSortField = Integer.parseInt(sort);
			theCustomers = customerService.getCustomers(theSortField);			
		}
		else {
			// no sort field provided ... default to sorting by last name
			theCustomers = customerService.getCustomers(SortUtils.LAST_NAME);
		}
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		//get the customer from the database
		Customer theCustomer = customerService.getCustomer(theId);
		//set the ModelAttribute
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId, Model theModel) {
		//get the customer from the database
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	@GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {
        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";        
    }
	
	
	
}
