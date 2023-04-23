package com.petkpetk.service.domain.user.service.notuse;// package com.petkpetk.service.domain.user.service.notuse;
//
// import java.io.Serializable;
// import java.util.Collection;
// import java.util.HashMap;
// import java.util.Map;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.AuthorityUtils;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
// import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import org.springframework.stereotype.Service;
//
// import com.petkpetk.service.common.AuditingFields;
// import com.petkpetk.service.config.security.oauth2.OAuth2ProviderInfo;
// import com.petkpetk.service.config.security.oauth2.OAuth2UserAccount;
// import com.petkpetk.service.domain.user.dto.UserAccountDto;
// import com.petkpetk.service.domain.user.entity.ProfileImage;
// import com.petkpetk.service.domain.user.service.UserAccountService;
//
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
//
// @Slf4j
// @Service
// @Transactional
// public class SocialUserAccountService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//     private UserAccountService userAccountService;
//
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
//     public OAuth2UserAccount KAKAO = (oAuth2User) -> {
//         Map<String, Object> properties = oAuth2User.getAttribute("properties");
//         Map<String, Object> kakaoAccount = oAuth2User.getAttribute("kakao_account");
//
//         String email = (String) kakaoAccount.get("email");
//         String name = (String) properties.get("nickname");
//         String profileImageUrl = (String) properties.get("profile_image");
//
//         UserAccountDto userAccountDto = userAccountService.createOrGetUser(new UserAccountCreateRequestDto()
//                 .setEmail(email)
//                 .setOAuth2ProviderInfo(new OAuth2ProviderInfo(OAuth2ProviderType.KAKAO, oAuth2User.getName()))
//                 .setProfileImage(new ProfileImage(profileImageUrl))
//                 .setNickname(name));
//
//         return OAuth2UserAccountPrincipal.from(userAccountDto);
//     };
//
//     public OAuth2UserAccount NAVER = (oAuth2User) -> {
//         Map<String, Object> response = oAuth2User.getAttribute("response");
//
//         String email = (String) response.get("email");
//         String name = (String) response.get("name");
//         String profileImageUrl = (String) response.get("profile_image");
//
//         UserAccountDto userAccountDto = userAccountService.createOrGetUser(new UserAccountCreateRequestDto()
//                 .setEmail(email)
//                 .setOAuth2ProviderInfo(new OAuth2ProviderInfo(OAuth2ProviderType.NAVER, oAuth2User.getName()))
//                 .setProfileImage(new ProfileImage(profileImageUrl))
//                 .setNickname(name));
//
//         return OAuth2UserAccountPrincipal.from(userAccountDto);
//     };
// }
//
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @EqualsAndHashCode(callSuper = true)
// public class OAuth2UserAccountPrincipal extends AuditingFields implements UserDetails, Serializable {
//
//     private Long
//
// }
//
//
//     public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//         String clientRegistrationId = userRequest.getClientRegistration().getRegistrationId();
//         OAuth2UserService<OAuth2UserRequest, OAuth2User> userService = new DefaultOAuth2UserService();
//
//         OAuth2User oAuth2User = userService.loadUser(userRequest);
//
//         OAuth2UserAccount oAuth2UserAccount = oAuth2Users.get(clientRegistrationId.toLowerCase());
//         OAuth2UserAccountPrincipal principal = oAuth2UserAccount.signup(oAuth2User);
//         return principal;
//     }
//
//
//
//     public OAuth2UserAccountPrincipal signup(OAuth2User oAuth2User) {
//         // 사용자 정보 추출
//         Map<String, Object> attributes = oAuth2User.getAttributes();
//
//         // OAuth2UserAccountPrincipal 객체 생성
//         OAuth2UserAccountPrincipal principal = new OAuth2UserAccountPrincipal();
//         principal.setEmail((String) attributes.get("email"));
//         principal.setName((String) attributes.get("name"));
//         principal.setNickname((String) attributes.get("nickname"));
//
//         // 필요한 정보들 추가
//         // ...
//
//         // 권한 정보 추가
//         Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE
//     }}
//
//
// public class SocialUserAccountService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//     @Override
//     public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//         String clientRegistrationId = userRequest.getClientRegistration().getRegistrationId();
//         OAuth2UserService<OAuth2UserRequest, OAuth2User> userService = new DefaultOAuth2UserService();
//
//         OAuth2User oAuth2User = userService.loadUser(userRequest);
//
//         OAuth2UserAccount oAuth2UserAccount = oAuth2Users.get(clientRegistrationId.toLowerCase());
//         OAuth2UserAccountPrincipal principal = OAuth2UserAccountPrincipal.create(oAuth2UserAccount, oAuth2User.getAttributes());
//         return principal;
//     }
// }
