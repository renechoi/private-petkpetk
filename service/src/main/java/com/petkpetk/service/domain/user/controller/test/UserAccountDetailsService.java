package com.petkpetk.service.domain.user.controller.test;// package com.petkpetk.service.domain.user.controller.test;
//
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
//
// import com.petkpetk.service.domain.user.dto.security.UserAccountPrincipal;
// import com.petkpetk.service.domain.user.service.UserAccountService;
//
// @Service
// @Transactional
// public class UserAccountDetailsService implements UserDetailsService {
//
//     private final UserAccountService userAccountService;
//
//     public UserAccountDetailsService(UserAccountService userAccountService) {
//         this.userAccountService = userAccountService;
//     }
//
//     @Override
//     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//         return userAccountService.searchUserDto(email)
//                 .map(UserAccountPrincipal::from)
//                 .orElseThrow(() -> new UsernameNotFoundException("회원을 찾을 수 없습니다"));
//     }
// }
