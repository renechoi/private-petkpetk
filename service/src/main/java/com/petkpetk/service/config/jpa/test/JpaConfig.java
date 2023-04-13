package com.petkpetk.service.config.jpa.test;// package com.petkpetk.service.config.jpa.test;
//
// import java.util.Optional;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.domain.AuditorAware;
// import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
//
// @EnableJpaAuditing(auditorAwareRef = "auditorProvider")
// @Configuration
// public class JpaConfig {
//
//     @Bean
//     public AuditorAware<String> auditorProvider() {
//         return new SpringSecurityAuditorAware();
//     }
//
//     public class SpringSecurityAuditorAware implements AuditorAware<String> {
//
//         @Override
//         public Optional<String> getCurrentAuditor() {
//             Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//             if (authentication == null || !authentication.isAuthenticated()) {
//                 // 인증되지 않은 사용자일 경우, 이름을 직접 입력받은 값을 사용
//                 return Optional.of("defaultUser");
//             }
//             // 인증된 사용자일 경우, 현재 사용자의 이름을 반환
//             return Optional.of(authentication.getName());
//         }
//     }
// }
