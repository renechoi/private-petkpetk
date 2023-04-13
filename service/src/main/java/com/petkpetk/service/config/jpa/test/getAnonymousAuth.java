package com.petkpetk.service.config.jpa.test;// package com.petkpetk.service.config.jpa.test;
//
// import org.springframework.security.authentication.AnonymousAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
//
// public class getAnonymousAuth {
// 	public static void main(String[] args) {
// 		// Set createdBy value using AnonymousAuthenticationToken's name
// 		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
// 		if (authentication instanceof AnonymousAuthenticationToken) {
// 			AnonymousAuthenticationToken anonymousAuthenticationToken = (AnonymousAuthenticationToken) authentication;
// 			String name = anonymousAuthenticationToken.getName();
// 			System.out.println("name = " + name);
// 			userAccount.setCreatedBy(anonymousAuthenticationToken.getName());
// 		}
// 	}
// }
