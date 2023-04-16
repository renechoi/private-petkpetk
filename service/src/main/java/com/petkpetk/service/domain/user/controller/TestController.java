package com.petkpetk.service.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.petkpetk.service.common.StatusCode;
import com.petkpetk.service.config.exception.PetkpetkServerException;
import com.petkpetk.service.domain.user.exception.UserDuplicateException;

@Controller
public class TestController {

	// @GetMapping("/")
	// @ResponseBody
	// public String test() {
	// 	SecurityContext context = SecurityContextHolder.getContext();
	// 	Authentication authentication = context.getAuthentication();
	// 	boolean authenticated = authentication.isAuthenticated();
	// 	Object details = authentication.getDetails();
	// 	Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	// 	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	//
	// 	String result = principal + "<br>" + context.toString() + "\n" + authentication.toString() + "\n" + authenticated + "\n" + details.toString() + "\n" + authorities.toString();
	//
	// 	return result;
	// }

	@GetMapping("/")
	public String home(){
		return "/index";
	}


	@GetMapping("/user/errortest")
	public String error(){
		throw new UserDuplicateException();
		// throw new PetkpetkServerException(StatusCode.INTERNAL_SERVER_ERROR);
	}

}
