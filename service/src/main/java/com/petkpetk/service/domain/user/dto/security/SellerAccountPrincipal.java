package com.petkpetk.service.domain.user.dto.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.petkpetk.service.common.AuditingFields;
import com.petkpetk.service.common.RoleType;
import com.petkpetk.service.config.security.oauth2.OAuth2ProviderInfo;
import com.petkpetk.service.domain.user.dto.SellerAccountDto;
import com.petkpetk.service.domain.user.entity.embedded.Address;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class SellerAccountPrincipal extends AuditingFields implements UserDetails {

	private Long id;

	private String email;
	private String password;

	private String name;

	private String nickname;

	private Address address;

	private String profileImage;

	private OAuth2ProviderInfo OAuth2ProviderInfo;

	private Collection<? extends GrantedAuthority> roles;

	private String phoneNumber;

	private String businessName;

	private String businessNumber;

	public SellerAccountPrincipal(Long id, String email, String password, String name, String nickname, Address address,
		String profileImage, OAuth2ProviderInfo OAuth2ProviderInfo, Collection<? extends GrantedAuthority> roles,
		String phoneNumber, String businessName, String businessNumber) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.address = address;
		this.profileImage = profileImage;
		this.OAuth2ProviderInfo = OAuth2ProviderInfo;
		this.roles = roles;
		this.phoneNumber = phoneNumber;
		this.businessName = businessName;
		this.businessNumber = businessNumber;
	}

	public static SellerAccountPrincipal of(Long id, String email, String password, String name, String nickname,
		Address address, String profileImage, OAuth2ProviderInfo OAuth2ProviderInfo, Set<RoleType> roles, String phoneNumber,
		String businessName, String businessNumber) {
		return new SellerAccountPrincipal(id, email, password, name, nickname, address, profileImage,
			OAuth2ProviderInfo,
			roles.stream()
				.map(RoleType::getRoleName)
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toUnmodifiableSet()), phoneNumber, businessName, businessNumber);
	}

	public static SellerAccountPrincipal from(SellerAccountDto dto) {
		return SellerAccountPrincipal.of(dto.getId(), dto.getEmail(), dto.getPassword(), dto.getName(),
			dto.getNickname(), dto.getAddress(), dto.getProfileImage(), dto.getOAuth2ProviderInfo(), dto.getRoles(),
			dto.getPhoneNumber(), dto.getBusinessName(), dto.getBusinessNumber());
	}

	public SellerAccountDto toDto() {

		return SellerAccountDto.of(id, email, password, name, nickname, address, profileImage, OAuth2ProviderInfo,
			roles.stream()
				.map(grantedAuthority -> RoleType.valueOf(grantedAuthority.getAuthority().substring(5)))
				.collect(Collectors.toUnmodifiableSet()), phoneNumber, businessName, businessNumber);

	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
