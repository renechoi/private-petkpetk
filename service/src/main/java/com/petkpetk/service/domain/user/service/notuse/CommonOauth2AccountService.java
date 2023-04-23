package com.petkpetk.service.domain.user.service.notuse;// package com.petkpetk.service.domain.user.service.notuse;
//
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
// public class CommonOauth2AccountService
// 	implements OAuth2UserService<OidcUserRequest, OidcUser>, UserService<OAuth2UserRequest, OAuth2User> {
// 	private final UserAccountService userAccountService;
//
// 	@Override
// 	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
// 		OidcUserService oidcUserService = new OidcUserService();
// 		OidcUser oidcUser = oidcUserService.loadUser(userRequest);
//
// 		// OidcUser에서 UserAccountDto를 만들어 저장하는 로직
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
// 	@Override
// 	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
// 		OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService = new DefaultOAuth2UserService();
// 		OAuth2User oauth2User = oauth2UserService.loadUser(userRequest);
//
// 		// OAuth2User에서 UserAccountDto를 만들어 저장하는 로직
// 		UserAccountDto userAccountDto = UserAccountDto.of(
// 			null,
// 			oauth2User.getAttribute("email").toString(),
// 			"undefined",
// 			oauth2User.getAttribute("name").toString(),
// 			"undefined",
// 			ProfileImage.of(oauth2User.getAttribute("picture").toString()),
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
// 		return oauth2User;
// 	}
//
// }