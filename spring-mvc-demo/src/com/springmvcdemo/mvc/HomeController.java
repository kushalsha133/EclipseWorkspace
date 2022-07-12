package com.springmvcdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//define this class as mvc controller
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";	
		//return "helloworld-form";	
	}
}