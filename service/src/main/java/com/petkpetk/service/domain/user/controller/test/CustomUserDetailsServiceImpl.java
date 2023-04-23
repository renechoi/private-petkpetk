package com.petkpetk.service.domain.user.controller.test;// package com.petkpetk.service.domain.user.controller.test;
//
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
//
// import com.petkpetk.service.config.security.oauth2.OAuth2UserAccount;
// import com.petkpetk.service.domain.user.dto.security.UserAccountPrincipal;
// import com.petkpetk.service.domain.user.service.SocialUserAccountService;
// import com.petkpetk.service.domain.user.service.OidcUserAccountService;
// import com.petkpetk.service.domain.user.service.UserAccountService;
//
// import lombok.RequiredArgsConstructor;
//
// @Service
// @Transactional
// @RequiredArgsConstructor
// public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
//
//     private final UserAccountService userAccountService;
//     private final SocialUserAccountService oAuth2UserAccountService;
//     private final OidcUserAccountService oidcUserAccountService;
//
//     @Override
//     public UserAccountPrincipal loadUserByUsername(String email) throws UsernameNotFoundException {
//         return userAccountService.searchUserDto(email)
//             .map(UserAccountPrincipal::from)
//             .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//     }
//
//     @Override
//     public OAuth2UserAccountPrincipal loadOAuth2UserByOAuth2ProviderAndEmail(String oAuth2Provider, String email) {
//         OAuth2UserAccount oAuth2UserAccount = oAuth2UserAccountService.loadUserByEmail(oAuth2Provider, email);
//         return OAuth2UserAccountPrincipal.from(oAuth2UserAccount);
//     }
//
//     @Override
//     public OidcUserAccountPrincipal loadOidcUserByOidcProviderAndEmail(String oidcProvider, String email) {
//         OidcUserAccount oidcUserAccount = oidcUserAccountService.loadUserByEmail(oidcProvider, email);
//         return OidcUserAccountPrincipal.from(oidcUserAccount);
//     }
// }
