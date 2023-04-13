package com.petkpetk.service.domain.user.service;

import java.util.Optional;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petkpetk.service.domain.user.dto.UserAccountDto;
import com.petkpetk.service.domain.user.entity.UserAccount;
import com.petkpetk.service.domain.user.exception.UserAccountDuplicateException;
import com.petkpetk.service.domain.user.repository.UserAccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserAccountService {

	private final UserAccountRepository userAccountRepository;

	public void save(UserAccountDto userAccountDto) {

		if (isDuplicate(userAccountDto.getEmail())) {
			throw new UserAccountDuplicateException();
		}

		UserAccount userAccount = userAccountDto.toEntity();

		userAccountRepository.save(userAccount);
	}

	private boolean isDuplicate(String email) {
		return userAccountRepository.findByEmail(email).isPresent();
	}

	public Optional<UserAccountDto> searchUser(String email) {
		return userAccountRepository.findByEmail(email).map(UserAccountDto::fromEntity);
	}
}
