package com.petkpetk.service.domain.user.controller.test;// package com.petkpetk.service.domain.user.controller.test;
//
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
//
// import com.petkpetk.service.domain.user.service.SocialUserAccountService;
//
// @Service
// @Transactional
// public class OAuth2UserAccountDetailsService implements UserDetailsService {
//
//     private final SocialUserAccountService oAuth2UserAccountService;
//
//     public OAuth2UserAccountDetailsService(SocialUserAccountService oAuth2UserAccountService) {
//         this.oAuth2UserAccountService = oAuth2UserAccountService;
//     }
//
//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         return oAuth2UserAccountService.loadUserByUsername(username);
//     }
// }
