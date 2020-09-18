package com.semiha.cookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/index")
	public String getHomePage() {
		
		return "index.html";
	}
	

}
