package com.petkpetk.service.domain.user.controller.test// package com.petkpetk.service.domain.user.controller.test
//
// import java.util.Optional;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
// import com.petkpetk.service.config.security.CustomAuthenticationEntryPoint;
// import com.petkpetk.service.config.security.OAuth2Config;
// import com.petkpetk.service.domain.user.dto.UserAccountDto;
// import com.petkpetk.service.domain.user.dto.security.UserAccountPrincipal;
// import com.petkpetk.service.domain.user.service.OidcUserAccountService;
// import com.petkpetk.service.domain.user.service.UserAccountService;
//
// import lombok.RequiredArgsConstructor;
//
// @Configuration
// @RequiredArgsConstructor
// public class SecurityConfig {
//
//     private final OAuth2Config oAuth2Config;
//     private final SocialUserAccountService SocialUserAccountService;
//     private final OidcUserAccountService oidcUserAccountService;
//     private final UserAccountService userAccountService;
//
//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//         return http.authorizeHttpRequests(
//                 auth -> auth.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
//                         .permitAll()
//                         .mvcMatchers("/", "/user/**", "/error/**", "/login", "/seller/sign-up", "/seller/**", "/admin/**",
//                                 "/test/**", "item/**").permitAll()
//                         .mvcMatchers("/api/**", "/explorer").permitAll()
//
//                         .anyRequest()
//                         .authenticated())
//
//                 .csrf(csrf -> csrf.ignoringAntMatchers("/api/**"))
//
//                 .formLogin(formLogin -> formLogin.loginPage("/login")
//                         .loginProcessingUrl("/login/process")
//                         .defaultSuccessUrl("/")
//                         .failureUrl("/login")
//                         .usernameParameter("email")
//                         .passwordParameter("password"))
//
//                 .oauth2Login(Customizer.withDefaults())
//                 .oauth2Login(oauth2 -> oauth2.clientRegistrationRepository(oAuth2Config.clientRegistrationRepository())
//                         .authorizedClientService(oAuth2Config.oAuth2AuthorizedClientService())
//                         .userInfoEndpoint(
//                                 user -> user.oidcUserService(oidcUserAccountService)
//                                         .userService(SocialUserAccountService)
//                         )
//                 )
//
//
//                 .logout(
//                         logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).logoutSuccessUrl("/"))
//
//                 .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint()).and()
//
//                 .build();
//     }
//
//     @Bean
//     public UserDetailsService userDetailsService() {
//         return email -> userAccountService.searchUserDto(email)
//                 .map(UserAccountPrincipal::from)
//                 .orElseThrow(() -> new UsernameNotFoundException("회원을 찾을 수 없습니다"));
//     }
//
//
//     @Bean
//     public UserDetailsService userDetailsService() {
//         return email -> {
//             Optional<UserAccountDto> optionalUserAccountDto = userAccountService.searchUserDto(email);
//             if (optionalUserAccountDto.isPresent()) {
//                 return UserAccountPrincipal.from(optionalUserAccountDto.get());
//             } else {
//                 Optional<OAuth2UserAccountDto> optionalOAuth2UserAccountDto = SocialUserAccountService.searchUserDto(email);
//                 if (optionalOAuth2UserAccountDto.isPresent()) {
//                     return OAuth2UserAccountPrincipal.from(optionalOAuth2UserAccountDto.get());
//                 } else {
//                     throw new UsernameNotFoundException("회원을 찾을 수 없습니다");
//                 }
//             }
//         };
//     }
//
//
// }
