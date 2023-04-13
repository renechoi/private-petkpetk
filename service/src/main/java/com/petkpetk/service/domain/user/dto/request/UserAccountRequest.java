package com.petkpetk.service.domain.user.dto.request;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.petkpetk.service.domain.user.constant.RoleType;
import com.petkpetk.service.domain.user.constant.SignUpProvider;
import com.petkpetk.service.domain.user.dto.UserAccountDto;
import com.petkpetk.service.domain.user.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountRequest {

	private Long id;

	@NotBlank(message = "이메일을 입력해주세요.")
	private String email;
	@NotBlank(message = "비밀번호를 입력해주세요.")
	private String password;
	@NotBlank(message = "이름을 입력해주세요.")
	private String name;
	@NotBlank(message = "닉네임을 입력해주세요.")
	private String nickname;

	@Valid
	@NotNull
	@NotBlank(message = "주소를 입력해주세요.")
	private Address address;
	private String profileImage;
	private SignUpProvider signUpProvider;
	private Set<RoleType> roles;

	public UserAccountDto toDto() {
		return UserAccountDto.of(
			null,
			this.email,
			this.password,
			this.name,
			this.nickname,
			this.address,
			this.profileImage,
			this.signUpProvider,
			Set.of(RoleType.USER)
		);
	}

}


