package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPageController {

	
	@GetMapping("/login")
	public String loginPageForm() {
		
		return "loginForm";
	}
}
