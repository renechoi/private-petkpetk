package com.petkpetk.service.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerController {

	@GetMapping("/information")
	public String informationView(){
		return "my-page/sellerMyPage";
	}
}
