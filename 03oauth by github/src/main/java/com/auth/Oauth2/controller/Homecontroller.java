package com.auth.Oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Homecontroller {
	
	@GetMapping("/")
	public String greet() {
		return "Welcome Page ";
	}

}
