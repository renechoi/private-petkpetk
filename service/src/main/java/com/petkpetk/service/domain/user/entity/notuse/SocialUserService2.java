package com.petkpetk.service.domain.user.entity.notuse;// package com.petkpetk.service.domain.user.entity.notuse;
//
// import java.util.Map;
//
// import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
// import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
// import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
//
// import com.petkpetk.service.config.exception.PetkpetkServerException;
// import com.petkpetk.service.domain.user.repository.UserAccountRepository;
// import com.petkpetk.service.config.security.oauth2.OAuth2UserInfo;
//
// import lombok.RequiredArgsConstructor;
//
// @Service
// @Transactional
// @RequiredArgsConstructor
// public class SocialUserService2 implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
// 	private final UserAccountRepository userAccountRepository;
//
//
// 	@Override
// 	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
// 		String clientRegistrationId = userRequest.getClientRegistration().getRegistrationId();
// 		OAuth2UserService<OAuth2UserRequest, OAuth2User> userService = new DefaultOAuth2UserService();
// 		OAuth2User oAuth2User = userService.loadUser(userRequest);
//
// 		OAuth2UserInfo userInfo = userInfoMap.getOrDefault(clientRegistrationId,
// 			notFound -> { throw new PetkpetkServerException(); });
//
// 		return userInfo.apply(oAuth2User);
// 	}
//
// 	private final Map<String, OAuth2UserInfo> userInfoMap = Map.of(
// 		"google", oAuth2User -> {
// 			String name = oAuth2User.getAttributes().get("name").toString();
// 			String email = oAuth2User.getAttributes().get("email").toString();
// 			save(name, email);
//
// 			return new DefaultOAuth2User(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), "sub");
// 		},
// 		"kakao", oAuth2User -> {
// 			Map<String, Object> properties = oAuth2User.getAttribute("properties");
// 			Map<String, Object> kakaoAccount = oAuth2User.getAttribute("kakao_account");
//
// 			String name = properties.get("nickname").toString();
// 			String email = kakaoAccount.get("email").toString();
// 			save(name, email);
//
// 			return new DefaultOAuth2User(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), "id");
// 		},
// 		"naver", oAuth2User -> {
// 			Map<String, Object> attributes = oAuth2User.getAttribute("response");
//
// 			String name = attributes.get("name").toString();
// 			String email = attributes.get("email").toString();
// 			String nickname = attributes.get("nickname").toString();
// 			String profileImage = attributes.get("profile_image").toString();
// 			save(name, email);
//
// 			return new DefaultOAuth2User(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), "response");
// 		}
// 	);
//
// 	public void save(String name, String email) {
// 		boolean exists = userAccountRepository.existsByEmail(email);
//
// 		if (!exists) {
// 			System.out.println("영속화 필요 name = " + name);
// 			// todo : db 영속화
// 		}
// 	}
// }
