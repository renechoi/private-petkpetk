package com.petkpetk.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/login")
	public String admin(){
		return "login";
	}

	@GetMapping("/register")
	public String register(){
		return "register";
	}

	@GetMapping("/tables")
	public String tables(){
		return "tables";
	}

}
