package com.kushal.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	 //this path was specified in securityConfig
	@GetMapping("/showMyLoginPage")
	public String showMyLoggingPage() {
		return "fancy-login";
	}
}
