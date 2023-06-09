package com.petkpetk.service.config.security.oauth2;

import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

@FunctionalInterface
public interface OAuth2UserInfo {
	OAuth2User register(OAuth2User oAuth2User) throws OAuth2AuthenticationException;
}



