package com.petkpetk.service.domain.user.service.notuse;// package com.petkpetk.service.domain.user.service.notuse;
//
// import java.util.HashMap;
// import java.util.Map;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
// import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
// import org.springframework.security.oauth2.client.registration.ClientRegistration;
// import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
// import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
// import org.springframework.security.oauth2.core.oidc.user.OidcUser;
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
//
// import com.petkpetk.service.config.security.oauth2.OAuth2ProviderInfo;
// import com.petkpetk.service.config.security.oauth2.OAuth2UserAccount;
// import com.petkpetk.service.domain.user.dto.security.OAuth2UserAccountPrincipal;
// import com.petkpetk.service.domain.user.service.UserAccountService;
//
// import lombok.extern.slf4j.Slf4j;
//
// @Slf4j
// @Service
// @Transactional
// public class OAuth2UserAccountService3 implements OAuth2UserService<OAuth2UserRequest, OAuth2User>   {
// 	private UserAccountService userAccountService;
//
// 	private Map<String, OAuth2UserAccount> oAuth2Users = new HashMap<>();
//
// 	@Autowired
// 	public OAuth2UserAccountService3(UserAccountService userAccountService) {
// 		this.userAccountService = userAccountService;
// 		oAuth2Users = Map.of(OAuth2ProviderInfo.KAKAO.getProviderId(), KAKAO, OAuth2ProviderInfo.NAVER.getProviderId(),
// 			NAVER, OAuth2ProviderInfo.GOOGLE.getProviderId(), GOOGLE);
// 	}
//
// 	@Override
// 	public OAuth2UserAccountPrincipal loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
// 		ClientRegistration clientRegistration = userRequest.getClientRegistration();
// 		System.out.println("clientRegistration = " + clientRegistration);
//
// 		OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();
//
// 		OAuth2UserAccount oAuth2UserAccount = oAuth2Users.get(
// 			userRequest.getClientRegistration().getRegistrationId().toLowerCase());
//
// 		return oAuth2UserAccount.signup(oAuth2UserService.loadUser(userRequest));
// 	}
//
//
// 	public OAuth2UserAccountPrincipal loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
//
// 		OidcUserService oidcUserService = new OidcUserService();
// 		System.out.println("oidcUserService = " + oidcUserService);
//
// 		OAuth2UserAccount oAuth2UserAccount = oAuth2Users.get(
// 			userRequest.getClientRegistration().getRegistrationId().toLowerCase());
//
// 		return oAuth2UserAccount.signup(oidcUserService.loadUser(userRequest));
// 	}
//
// 	public OAuth2UserAccount KAKAO = (oAuth2User) -> {
// 		OAuth2UserAccountPrincipal oAuth2UserAccountPrincipal = OAuth2UserAccountPrincipal.fromOAuth2(
// 			getKakaoAttributes(oAuth2User));
// 		userAccountService.saveSocialUser(oAuth2UserAccountPrincipal);
// 		return oAuth2UserAccountPrincipal;
// 	};
//
// 	public OAuth2UserAccount NAVER = (oAuth2User) -> {
// 		OAuth2UserAccountPrincipal oAuth2UserAccountPrincipal = OAuth2UserAccountPrincipal.fromOAuth2(
// 			getNaverAttributes(oAuth2User));
// 		userAccountService.saveSocialUser(oAuth2UserAccountPrincipal);
// 		return oAuth2UserAccountPrincipal;
// 	};
//
// 	public OAuth2UserAccount GOOGLE = (oidcUser) -> {
// 		OAuth2UserAccountPrincipal oAuth2UserAccountPrincipal = OAuth2UserAccountPrincipal.fromOidc(
// 			getGoogleAttributes(oidcUser));
// 		userAccountService.saveSocialUser(oAuth2UserAccountPrincipal);
// 		return oAuth2UserAccountPrincipal;
// 	};
//
// 	private Map<String, Object> getKakaoAttributes(OAuth2User oAuth2User) {
// 		Map<String, Object> kakaoAttributes = Stream.of("properties", "kakao_account")
// 			.flatMap(key -> ((Map<String, Object>)oAuth2User.getAttribute(key)).entrySet().stream())
// 			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
// 		kakaoAttributes.put("providerInfo", "kakao");
// 		kakaoAttributes.put("nameAttributeKey", "id");
// 		return kakaoAttributes;
// 	}
//
// 	private Map<String, Object> getNaverAttributes(OAuth2User oAuth2User) {
// 		Map<String, Object> naverAttributes = oAuth2User.getAttribute("response");
// 		naverAttributes.put("providerInfo", "naver");
// 		naverAttributes.put("nameAttributeKey", "response");
// 		return naverAttributes;
// 	}
//
// 	private Map<String, Object> getGoogleAttributes(OAuth2User oAuth2User) {
// 		OidcUser oidcUser = (OidcUser) oAuth2User;
// 		Map<String, Object> googleAttributes = oidcUser.getAttributes();
// 		googleAttributes.put("providerInfo", "google");
// 		googleAttributes.put("nameAttributeKey", "sub");
// 		googleAttributes.put("idToken", oidcUser.getIdToken());
// 		googleAttributes.put("userInfo", oidcUser.getUserInfo());
// 		return googleAttributes;
// 	}
// }
//
//
//
//
