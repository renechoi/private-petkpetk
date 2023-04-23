package com.petkpetk.service.domain.user.dto.request;

import java.util.Set;

import com.petkpetk.service.common.RoleType;
import com.petkpetk.service.config.converter.EntityAndDtoConverter;
import com.petkpetk.service.config.security.oauth2.OAuth2ProviderInfo;
import com.petkpetk.service.domain.user.entity.ProfileImage;
import com.petkpetk.service.domain.user.entity.UserAccount;
import com.petkpetk.service.domain.user.entity.embedded.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OAuth2UserSignupRequest {

	private Long id;
	private String email;

	private String password;
	private String name;
	private String nickname;

	private ProfileImage profileImage;
	private Address address;
	private OAuth2ProviderInfo OAuth2ProviderInfo;
	private Set<RoleType> roles;

	private String phoneNumber;

	private String businessName;

	private String businessNumber;

	public OAuth2UserSignupRequest(String email, String name, String nickname, ProfileImage profileImage,
		Address address,
		OAuth2ProviderInfo OAuth2ProviderInfo, Set<RoleType> roles) {
		this.email = email;
		this.name = name;
		this.nickname = nickname;
		this.profileImage = profileImage;
		this.address = address;
		this.OAuth2ProviderInfo = OAuth2ProviderInfo;
		this.roles = roles;
	}

	public UserAccount toEntity() {
		return EntityAndDtoConverter.convertToEntity(this, UserAccount.class);
	}

	public UserAccount toEntity(ProfileImage profileImage) {
		UserAccount userAccount = EntityAndDtoConverter.convertToEntity(this, UserAccount.class);
		userAccount.addImage(profileImage);
		return userAccount;
	}

	public static OAuth2UserSignupRequest of(String email, String name, String nickname, ProfileImage profileImage,
		OAuth2ProviderInfo oAuth2ProviderInfo) {
		return new OAuth2UserSignupRequest(email, name, nickname, profileImage, new Address(), oAuth2ProviderInfo,
			Set.of(RoleType.USER));
	}

}
