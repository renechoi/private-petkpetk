package com.petkpetk.service.domain.user.service.notuse// import java.util.Map;
// import java.util.Set;
//
// import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
// import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
// import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
// import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
// import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
// import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
// import org.springframework.security.oauth2.core.oidc.user.OidcUser;
// import org.springframework.security.oauth2.core.user.OAuth2User;
// import org.springframework.stereotype.Service;
// import org.springframework.util.StringUtils;
//
// import com.petkpetk.service.common.RoleType;
// import com.petkpetk.service.config.security.oauth2.OAuth2ProviderInfo;
// import com.petkpetk.service.domain.user.dto.UserAccountDto;
// import com.petkpetk.service.domain.user.entity.ProfileImage;
// import com.petkpetk.service.domain.user.service.UserAccountService;
//
// import lombok.RequiredArgsConstructor;
//
// @Service
// @RequiredArgsConstructor
// public class CommonOauth2AccountService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>,
// 	OAuth2UserService<OidcUserRequest, OidcUser> {
// 	private final UserAccountService userAccountService;
//
// 	@Override
// 	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
// 		OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
// 		OAuth2User oAuth2User = delegate.loadUser(userRequest);
//
// 		String providerInfo = userRequest.getClientRegistration().getClientName().toLowerCase();
// 		Map<String, Object> attributes = oAuth2User.getAttributes();
// 		attributes.put("providerInfo", providerInfo);
//
// 		String nameAttributesKey = "name";
// 		if (StringUtils.hasText(providerInfo) && providerInfo.equals("naver")) {
// 			nameAttributesKey = "nickname";
// 		} else if (StringUtils.hasText(providerInfo) && providerInfo.equals("kakao")) {
// 			nameAttributesKey = "nickname";
// 		}
// 		attributes.put("nameAttributesKey", nameAttributesKey);
//
// 		UserAccountDto userAccountDto = UserAccountDto.of(
// 			null,
// 			oAuth2User.getAttribute("email"),
// 			"undefined",
// 			oAuth2User.getAttribute(nameAttributesKey),
// 			"undefined",
// 			ProfileImage.of(oAuth2User.getAttribute("picture")),
// 			new Address(),
// 			OAuth2ProviderInfo.valueOf(providerInfo.toUpperCase()),
// 			Set.of(RoleType.USER),
// 			null,
// 			null,
// 			null
// 		);
// 		userAccountService.saveSocialUser(userAccountDto);
//
// 		return oAuth2User;
// 	}
//
// 	@Override
// 	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
// 		OidcUserService oidcUserService = new OidcUserService();
// 		OidcUser oidcUser = oidcUserService.loadUser(userRequest);
//
// 		UserAccountDto userAccountDto = UserAccountDto.of(
// 			null,
// 			oidcUser.getAttributes().get("email").toString(),
// 			"undefined",
// 			oidcUser.getAttributes().get("name").toString(),
// 			"undefined",
// 			ProfileImage.of(oidcUser.getAttributes().get("picture").toString()),
// 			new Address(),
// 			OAuth2ProviderInfo.GOOGLE,
// 			Set.of(RoleType.USER),
// 			null,
// 			null,
// 			null
// 		);
//
// 		userAccountService.saveSocialUser(userAccountDto);
//
// 		return new DefaultOidcUser(
// 			oidcUser.getAuthorities(), oidcUser.getIdToken(), oidcUser.getUserInfo()
// 		);
// 	}
//
// }