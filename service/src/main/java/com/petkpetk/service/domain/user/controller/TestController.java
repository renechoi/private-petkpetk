package com.petkpetk.service.domain.user.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@GetMapping("/")
	@ResponseBody
	public String test() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		boolean authenticated = authentication.isAuthenticated();
		Object details = authentication.getDetails();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String result = principal + "<br>" + context.toString() + "\n" + authentication.toString() + "\n" + authenticated + "\n" + details.toString() + "\n" + authorities.toString();

		return result;
	}

}
