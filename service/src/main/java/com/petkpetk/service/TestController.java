package com.petkpetk.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/test")
public class TestController {

	@GetMapping("")
	public String home(){
		return "/index2";
	}


	@PostMapping("/post")
	public String postTest(){
		return "redirect:/";
	}

}
