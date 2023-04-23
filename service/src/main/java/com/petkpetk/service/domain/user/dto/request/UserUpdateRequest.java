package com.petkpetk.service.domain.user.dto.request;

import java.io.IOException;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
public class UserUpdateRequest {

	private Long id;

	private String email;

	@Length(min = 8, max = 16, message = "비밀번호는 8자 이상 16자 이하로 입력해주세요")
	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String password;
	private String name;
	@NotBlank(message = "닉네임을 입력해주세요.")
	private String nickname;

	private MultipartFile profileImage;
	@Valid
	@NotNull
	@NotBlank(message = "주소를 입력해주세요.")
	private Address address;
	private OAuth2ProviderInfo OAuth2ProviderInfo;
	private Set<RoleType> roles;


	private String phoneNumber;

	private String businessName;

	private String businessNumber;

	public static UserUpdateRequest from(UserAccount userAccount, MultipartFile profileImage) {
		return new UserUpdateRequest(userAccount.getId(), userAccount.getEmail(), userAccount.getPassword(),
			userAccount.getName(), userAccount.getNickname(), profileImage, userAccount.getAddress(),userAccount.getOAuth2ProviderInfo(),userAccount.getRoles(),
			userAccount.getPhoneNumber(), userAccount.getBusinessName(), userAccount.getBusinessNumber());
	}

	public UserAccount toEntity() {
		return EntityAndDtoConverter.convertToEntity(this, UserAccount.class);
	}

	public UserAccount toEntity(ProfileImage profileImage) {
		UserAccount userAccount = EntityAndDtoConverter.convertToEntity(this, UserAccount.class);
		userAccount.setProfileImage(profileImage);
		return userAccount;
	}
}
