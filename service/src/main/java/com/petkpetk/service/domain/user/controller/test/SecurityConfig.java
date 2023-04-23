package com.petkpetk.service.domain.user.controller.test;// package com.petkpetk.service.domain.user.controller.test;
//
// import java.util.ArrayList;
// import java.util.List;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
//
// import com.petkpetk.service.domain.user.service.SocialUserAccountService;
// import com.petkpetk.service.domain.user.service.OidcUserAccountService;
//
// import lombok.RequiredArgsConstructor;
//
// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//     @Autowired
//     private SocialUserAccountService oauth2UserAccountService;
//
//     @Autowired
//     private OidcUserAccountService oidcUserAccountService;
//
//     @Autowired
//     private UserAccountDetailsService userAccountDetailsService;
//
//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//                 .antMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
//                 .antMatchers("/", "/login**").permitAll()
//                 .anyRequest().authenticated()
//                 .and()
//             .oauth2Login()
//                 .userInfoEndpoint()
//                     .userService(oauth2UserAccountService)
//                     .oidcUserService(oidcUserAccountService)
//                     .and()
//                 .successHandler((request, response, authentication) -> {
//                     // handle successful OAuth2 login (optional)
//                 })
//                 .and()
//             .formLogin()
//                 .loginPage("/login")
//                 .defaultSuccessUrl("/")
//                 .permitAll()
//                 .and()
//             .logout()
//                 .logoutUrl("/logout")
//                 .logoutSuccessUrl("/")
//                 .invalidateHttpSession(true)
//                 .deleteCookies("JSESSIONID")
//                 .permitAll()
//                 .and()
//             .csrf()
//                 .disable();
//     }
//
//     @Override
//     public void configure(WebSecurity web) throws Exception {
//         web.ignoring().antMatchers("/favicon.ico");
//     }
//
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
//
//     @Override
//     @Bean
//     public AuthenticationManager authenticationManagerBean() throws Exception {
//         return super.authenticationManagerBean();
//     }
//
//     @Override
//     @Bean
//     public UserDetailsService userDetailsService() {
//         List<UserDetailsService> userDetailsServiceList = new ArrayList<>();
//         userDetailsServiceList.add(userAccountDetailsService);
//         userDetailsServiceList.add(oauth2UserAccountDetailsService);
//         userDetailsServiceList.add(oidcUserAccountDetailsService);
//
//         return new CompositeUserDetailsService(user
//
//
//
//     }
// }
//
// @Configuration
// @EnableWebSecurity
// @RequiredArgsConstructor
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//     private final CustomUserDetailsService customUserDetailsService;
//
//     ...
//
//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(customUserDetailsService);
//     }
//
//     ...
// }
