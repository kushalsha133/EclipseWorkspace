package com.kushal.springboot.demo.MyApp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	
	@GetMapping("/")
	public String sayHello() {
		return "Server Time:"+LocalDateTime.now();
	}
}
