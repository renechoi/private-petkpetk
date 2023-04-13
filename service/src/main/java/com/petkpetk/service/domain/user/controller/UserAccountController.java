package com.petkpetk.service.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petkpetk.service.domain.user.dto.request.UserAccountRequest;
import com.petkpetk.service.domain.user.service.UserAccountService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class UserAccountController {

	private final UserAccountService userAccountService;

	@GetMapping("/sign-up")
	public String signUp(Model model) {
		model.addAttribute(new UserAccountRequest());
		return "user/sign-up";
	}

	@PostMapping("/sign-up")
	public String signUp(UserAccountRequest userAccountRequest) {
		userAccountService.save(userAccountRequest.toDto());
		return "redirect:/user/login";
	}

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
}

