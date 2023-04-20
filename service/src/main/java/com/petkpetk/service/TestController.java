package com.petkpetk.service;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petkpetk.service.domain.user.entity.UserAccount;

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


	//
	// @PostMapping("/sign-up")
	// public String signUp(@Valid UserAccount userAccount, BindingResult bindingResult) {
	// 	if (bindingResult.hasErrors()) {
	// 		return "user/sign-up";
	// 	}
	//
	// 	userAccount.setRole(Role.USER);
	// 	userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
	//
	// 	userRepository.save(userAccount);
	// 	return "redirect:/members/login";
	// }


}
