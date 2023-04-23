package com.petkpetk.service.domain.user.controller.test;// package com.petkpetk.service.domain.user.controller.test;
//
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import org.springframework.web.bind.annotation.GetMapping;
//
// import com.petkpetk.service.domain.user.dto.security.UserAccountPrincipal;
//
// public class cont {
//
// 	@GetMapping("/update")
// 	public String update(Authentication authentication,
// 		OAuth2User oAuth2User, Model model) {
//
// 		UserAccountPrincipal userAccountPrincipal =
// 			new UserAccountPrincipal(oAuth2User.getName(), oAuth2User.getAuthorities(), oAuth2User.getAttributes());
//
// 		model.addAttribute("userAccount", userAccountService.getUserUpdateRequestView(userAccountPrincipal));
// 		return "user/user/update";
// 	}
//
// }
