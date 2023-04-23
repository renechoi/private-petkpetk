package com.petkpetk.service.domain.user.controller.test;// package com.petkpetk.service.domain.user.controller.test;
//
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
//
// import com.petkpetk.service.domain.user.service.OidcUserAccountService;
//
// @Service
// @Transactional
// public class OidcUserAccountDetailsService implements UserDetailsService {
//
//     private final OidcUserAccountService oidcUserAccountService;
//
//     public OidcUserAccountDetailsService(OidcUserAccountService oidcUserAccountService) {
//         this.oidcUserAccountService = oidcUserAccountService;
//     }
//
//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         return oidcUserAccountService.loadUserByUsername(username);
//     }
// }
