package com.petkpetk.service.domain.user.entity.notuse;// package com.petkpetk.service.domain.user.entity.notuse;
//
// import static com.petkpetk.service.common.SignUpProvider.*;
//
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Optional;
// import java.util.function.Consumer;
// import java.util.function.Function;
// import java.util.stream.Stream;
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
// import com.petkpetk.service.common.SignUpProvider;
// import com.petkpetk.service.config.exception.PetkpetkServerException;
// import com.petkpetk.service.domain.user.repository.UserAccountRepository;
//
// import lombok.RequiredArgsConstructor;
//
// /**
//  * OAuth@UserService 클래스명을 spring security 이미 사용하고 있어서
//  * SocialUserService 명명
//  */
// @Service
// @Transactional
// @RequiredArgsConstructor
// public class SocialUserService
// 	implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
// 	private final UserAccountRepository userAccountRepository;
//
// 	@Override
// 	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
// 		String clientRegistrationId = userRequest.getClientRegistration().getRegistrationId();
// 		OAuth2UserService<OAuth2UserRequest, OAuth2User> userService = new DefaultOAuth2UserService();
//
// 		OAuth2User oAuth2User = userService.loadUser(userRequest);
//
// 		if (clientRegistrationId.equals("google")) {
//
// 			System.out.println("google oAuth2User = " + oAuth2User);
// 			String name = oAuth2User.getAttributes().get("name").toString();
// 			String email = oAuth2User.getAttributes().get("email").toString();
// 			save(name, email);
// 			return new DefaultOAuth2User(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), "sub");
//
// 		} else if (clientRegistrationId.equals("kakao")) {
// 			Map<String, Object> properties = (Map<String, Object>)oAuth2User.getAttributes().get("properties");
// 			Map<String, Object> kakaoAccount = (Map<String, Object>)oAuth2User.getAttributes().get("kakao_account");
// 			String name = properties.get("nickname").toString();
// 			String email = kakaoAccount.get("email").toString();
// 			save(name, email);
// 		} else if (clientRegistrationId.equals("naver")) {
//
// 			Map<String, Object> attributes = (Map<String, Object>)oAuth2User.getAttributes().get("response");
//
// 			String name = attributes.get("name").toString();
// 			String email = attributes.get("email").toString();
// 			String nickname = attributes.get("nickname").toString();
// 			String profileImage = attributes.get("profile_image").toString();
// 			save(name, email);
// 			return new DefaultOAuth2User(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), "response");
// 		}
//
// 		return new DefaultOAuth2User(oAuth2User.getAuthorities(), oAuth2User.getAttributes(), "id");
// 	}
//
//
// 	public void save(String name, String email) {
//
// 		boolean exists = userAccountRepository.existsByEmail(email);
//
// 		if (!exists) {
// 			System.out.println("영속화 필요 name = " + name);
// 			// todo : db 영속화
// 		}
// 	}
//
// }