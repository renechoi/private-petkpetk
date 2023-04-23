package com.petkpetk.service.domain.user.controller.test// package com.petkpetk.service.domain.user.controller.test
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
//
// @Controller
// public class MyController {
//
//     @Autowired
//     private OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService;
//
//     @GetMapping("/mypage")
//     public String myPage() {
//         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//         OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
//         OAuth2User oAuth2User = oAuth2UserService.loadUser(oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getPrincipal().getAttributes());
//         String email = oAuth2User.getAttribute("email");
//         // ...
//     }
// }
