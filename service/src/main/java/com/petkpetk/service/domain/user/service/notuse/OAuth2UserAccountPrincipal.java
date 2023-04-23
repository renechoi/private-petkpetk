package com.petkpetk.service.domain.user.service.notuse;// package com.petkpetk.service.domain.user.service.notuse;
//
// import java.io.Serializable;
// import java.util.Collection;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;
//
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.oauth2.core.user.OAuth2User;
//
// import com.petkpetk.service.config.security.oauth2.OAuth2UserAccount;
//
// public class OAuth2UserAccountPrincipal implements UserDetails, Serializable, OAuth2User {
//
//     private final Collection<? extends GrantedAuthority> authorities;
//     private final Map<String, Object> attributes;
//     private final String email;
//
//     public OAuth2UserAccountPrincipal(String email,
//                                       Collection<? extends GrantedAuthority> authorities,
//                                       Map<String, Object> attributes) {
//         this.email = email;
//         this.authorities = authorities;
//         this.attributes = attributes;
//     }
//
//     public static OAuth2UserAccountPrincipal create(OAuth2UserAccount user, Map<String, Object> attributes) {
//         List<GrantedAuthority> authorities = user.getRoles()
//             .stream()
//             .map(role -> new SimpleGrantedAuthority(role.getName().name()))
//             .collect(Collectors.toList());
//
//         return new OAuth2UserAccountPrincipal(user.getEmail(), authorities, attributes);
//     }
//
//     @Override
//     public String getName() {
//         return email;
//     }
//
//     @Override
//     public Collection<? extends GrantedAuthority> getAuthorities() {
//         return authorities;
//     }
//
//     @Override
//     public Map<String, Object> getAttributes() {
//         return attributes;
//     }
//
//     @Override
//     public String getPassword() {
//         return null;
//     }
//
//     @Override
//     public String getUsername() {
//         return email;
//     }
//
//     @Override
//     public boolean isAccountNonExpired() {
//         return true;
//     }
//
//     @Override
//     public boolean isAccountNonLocked() {
//         return true;
//     }
//
//     @Override
//     public boolean isCredentialsNonExpired() {
//         return true;
//     }
//
//     @Override
//     public boolean isEnabled() {
//         return true;
//     }
// }
