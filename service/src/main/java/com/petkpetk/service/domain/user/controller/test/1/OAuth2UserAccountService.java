package com.petkpetk.service.domain.user.controller.test// package com.petkpetk.service.domain.user.controller.test
//
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Optional;
// import java.util.Set;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
// import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
// import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import org.springframework.stereotype.Service;
//
// import com.petkpetk.service.common.RoleType;
// import com.petkpetk.service.config.security.oauth2.OAuth2ProviderInfo;
// import com.petkpetk.service.config.security.oauth2.OAuth2UserAccount;
// import com.petkpetk.service.domain.user.dto.UserAccountDto;
// import com.petkpetk.service.domain.user.dto.security.OAuth2UserAccountPrincipal;
// import com.petkpetk.service.domain.user.dto.security.UserAccountPrincipal;
// import com.petkpetk.service.domain.user.entity.ProfileImage;
// import com.petkpetk.service.domain.user.service.UserAccountService;
//
// @Service
// @Transactional
// public class SocialUserAccountService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//     private UserAccountService userAccountService;
//     private Map<String, OAuth2UserAccount> oAuth2Users = new HashMap<>();
//
//     @Autowired
//     public SocialUserAccountService(UserAccountService userAccountService) {
//         this.userAccountService = userAccountService;
//         oAuth2Users = Map.of(OAuth2ProviderInfo.KAKAO.getProviderId(), KAKAO, OAuth2ProviderInfo.NAVER.getProviderId(),
//                 NAVER);
//     }
//
//     @Override
//     public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//         String clientRegistrationId = userRequest.getClientRegistration().getRegistrationId();
//         OAuth2UserService<OAuth2UserRequest, OAuth2User> userService = new DefaultOAuth2UserService();
//
//         OAuth2User oAuth2User = userService.loadUser(userRequest);
//
//         OAuth2UserAccount oAuth2UserAccount = oAuth2Users.get(clientRegistrationId.toLowerCase());
//         return oAuth2UserAccount.signup(oAuth2User);
//     }
//
//     // email로 OAuth2UserAccountPrincipal 가져오기
//     public OAuth2UserAccountPrincipal searchOAuth2UserAccountPrincipal(String email) {
//         return userAccountService.searchOAuth2UserAccountDto(email)
//                 .map(OAuth2UserAccountPrincipal::from)
//                 .orElseThrow(() -> new UsernameNotFoundException("회원을 찾을 수 없습니다"));
//     }
//
//     public OAuth2UserAccount KAKAO = (oAuth2User) -> {
//         Map<String, Object> properties = oAuth2User.getAttribute("properties");
//         Map<String, Object> kakaoAccount = oAuth2User.getAttribute("kakao_account");
//
//         UserAccountDto userSignupRequest = UserAccountDto.of(null, kakaoAccount.get("email").toString(), "undefined",
//                 properties.get("nickname").toString(), properties.get("nickname").toString(),
//                 ProfileImage.of(properties.get("profile_image").toString()), new Address(), OAuth2ProviderInfo.KAKAO,
//                 Set.of(RoleType.USER), null, null, null);
//
//         userAccountService.saveSocialUser(userSignupRequest);
//
//         return new DefaultOAuth2User(
//                 Set.of(new SimpleGrantedAuthority(RoleType.USER.getRoleName())),
//                 oAuth2User.getAttributes(),
//                 OAuth2ProviderInfo.KAKAO.getProviderId()
//         );
//     };
//
//     public OAuth2UserAccount NAVER = (oAuth2User) -> {
//         Map<String, Object> response = oAuth2User.getAttribute("response");
//
//         UserAccountDto userSignupRequest = UserAccountDto.of(null, response.get("email").toString(), "undefined",
//                 response.get("name").toString(), response.get("nickname").toString(),
//                 ProfileImage.of(response.get("profile_image").toString()), new Address(), OAuth2ProviderInfo.NAVER,
//                 Set.of(RoleType
//     }}
//
//     @Bean
//     public UserDetailsService userDetailsService(UserAccountService userAccountService) {
//         return email -> {
//             Optional<UserAccountDto> userAccountDto = userAccountService.searchUserDto(email);
//             if (userAccountDto.isPresent()) {
//                 return UserAccountPrincipal.from(userAccountDto.get());
//             } else {
//                 Optional<OAuth2UserAccountDto> oAuth2UserAccountDto = userAccountService.searchOAuth2UserAccountDto(email);
//                 if (oAuth2UserAccountDto.isPresent()) {
//                     return OAuth2UserAccountPrincipal.from(oAuth2UserAccountDto.get());
//                 } else {
//                     throw new UsernameNotFoundException("회원을 찾을 수 없습니다");
//                 }
//             }
//         };
//     }
