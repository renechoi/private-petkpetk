package com.petkpetk.service.domain.user.service.notuse// package com.petkpetk.service.domain.user.service.notuse
//
// import java.io.Serializable;
// import java.util.Collection;
// import java.util.HashMap;
// import java.util.Map;
//
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.oauth2.core.oidc.OidcIdToken;
// import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
// import org.springframework.security.oauth2.core.oidc.user.OidcUser;
// import org.springframework.security.oauth2.core.user.OAuth2User;
//
// import com.petkpetk.service.common.AuditingFields;
// import com.petkpetk.service.domain.user.entity.ProfileImage;
//
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
//
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @EqualsAndHashCode(callSuper = true)
// public class OAuth2UserAccountPrincipal extends AuditingFields implements UserDetails, Serializable, OAuth2User,
//     OidcUser {
//
//     private Long id;
//
//     private String email;
//     private String password;
//
//     private String name;
//
//     private String nickname;
//
//     private ProfileImage profileImage;
//
//
//     private String address;
//
//     private OAuth2ProviderInfo OAuth2ProviderInfo;
//
//     private Collection<? extends GrantedAuthority> roles;
//
//     private String phoneNumber;
//
//     private String businessName;
//
//     private String businessNumber;
//
//     private String nameAttributeKey;
//     private Map<String, Object> attributes;
//
//     private OidcIdToken idToken;
//
//     private OidcUserInfo userInfo;
//
//     public OAuth2UserAccountPrincipal(String email, String name, String nickname, ProfileImage profileImage,
//                                       com.petkpetk.service.config.security.oauth2.OAuth2ProviderInfo OAuth2ProviderInfo,
//                                       Collection<? extends GrantedAuthority> roles, String nameAttributeKey, Map<String, Object> attributes) {
//         this.email = email;
//         this.name = name;
//         this.nickname = nickname;
//         this.profileImage = profileImage;
//         this.OAuth2ProviderInfo = OAuth2ProviderInfo;
//         this.roles = roles;
//         this.nameAttributeKey = nameAttributeKey;
//         this.attributes = attributes;
//     }
//
//     public OAuth2UserAccountPrincipal(String email, String name, String nickname, ProfileImage profileImage,
//                                       com.petkpetk.service.config.security.oauth2.OAuth2ProviderInfo OAuth2ProviderInfo,
//                                       Collection<? extends GrantedAuthority> roles, String nameAttributeKey, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo) {
//         this.email = email;
//         this.name = name;
//         this.nickname = nickname;
//         this.profileImage = profileImage;
//         this.OAuth2ProviderInfo = OAuth2ProviderInfo;
//         this.roles = roles;
//         this.nameAttributeKey = nameAttributeKey;
//         this.attributes = attributes;
//         this.idToken = idToken;
//         this.userInfo = userInfo;
//     }
//
//     public static OAuth2UserAccountPrincipal fromOAuth2(Map<String, Object> attributes) {
//         return new OAuth2UserAccountPrincipal(
//                 fetchEmail(attributes),
//                 fetchName(attributes),
//                 fetchNickname(attributes),
//                 fetch
//         @Override
//         public Map<String, Object> getClaims() {
//             Map<String, Object> claims = new HashMap<>();
//             // add other claims
//             Address address = getAddress();
//             if (address != null) {
//                 Map<String, Object> addressClaims = address.toMap();
//                 claims.putAll(addressClaims);
//             }
//             return claims;
//         }
//
// //
//
//     }}
//
//     @Override
//     public Map<String, Object> getClaims() {
//         Map<String, Object> claims = new HashMap<>();
//         // add other claims
//         Address address = getAddress();
//         if (address != null) {
//             Map<String, Object> addressClaims = address.toMap();
//             claims.putAll(addressClaims);
//         }
//         return claims;
//     }
