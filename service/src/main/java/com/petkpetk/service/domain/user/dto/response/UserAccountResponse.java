package com.petkpetk.service.domain.user.dto.response;

import java.util.Set;

import com.petkpetk.service.common.RoleType;
import com.petkpetk.service.config.security.oauth2.OAuth2ProviderInfo;
import com.petkpetk.service.domain.user.dto.UserAccountDto;
import com.petkpetk.service.domain.user.entity.ProfileImage;
import com.petkpetk.service.domain.user.entity.embedded.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountResponse {

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

	public static UserAccountResponse from(UserAccountDto dto) {
		return new UserAccountResponse(dto.getId(), dto.getEmail(), dto.getPassword(), dto.getName(), dto.getNickname(),
			dto.getProfileImage(), dto.getAddress(), dto.getOAuth2ProviderInfo(), dto.getRoles(), dto.getPhoneNumber(),
			dto.getBusinessName(), dto.getBusinessNumber());
	}
}
