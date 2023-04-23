package com.petkpetk.service.domain.user.service.notuse;// package com.petkpetk.service.domain.user.service.notuse;
//
// import java.util.Collection;
// import java.util.Collections;
// import java.util.Map;
//
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
// import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
// import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.GetMapping;
//
// import com.petkpetk.service.domain.user.dto.security.UserAccountPrincipal;
//
// @Service
// public class UserServiceImpl implements UserService, OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//   // ...
//
//   @Override
//   public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//     // ...
//     return new DefaultOAuth2User(
//             authorities,
//             userAttributes,
//             userNameAttributeName);
//   }
//
//   public DefaultOAuth2User(Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes, String nameAttributeKey) {
//     super(authorities);
//     Assert.notEmpty(attributes, "attributes cannot be empty");
//     Assert.hasText(nameAttributeKey, "nameAttributeKey cannot be empty");
//     this.attributes = Collections.unmodifiableMap(attributes);
//     this.nameAttributeKey = nameAttributeKey;
//   }
//
//   @GetMapping("/update")
//   public String update(Authentication authentication,
//       @AuthenticationPrincipal UserAccountPrincipal userAccountPrincipal, Model model) {
//     if (userAccountPrincipal == null && authentication != null && authentication.getPrincipal() instanceof OAuth2User) {
//       OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
//       userAccountPrincipal = UserAccountPrincipal.from(oAuth2User);
//     }
//     model.addAttribute("userAccount", userAccountService.getUserUpdateRequestView(userAccountPrincipal));
//     return "user/user/update";
//   }
//
// }
