package com.petkpetk.service.domain.user.entity.notuse;// package com.petkpetk.service.domain.user.entity.notuse;
//
// import lombok.*;
//
// import javax.persistence.*;
// import java.io.Serializable;
// import java.util.LinkedHashSet;
// import java.util.Set;
//
// import com.petkpetk.service.domain.user.entity.notuse.UrlResource;
// import com.petkpetk.service.domain.user.entity.UserAccount;
//
// @Entity
// @Table(name = "role")
// @Getter
// @Setter
// @ToString
// @NoArgsConstructor
// @AllArgsConstructor
// public class Role implements Serializable {
//
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//
//     private String roleName;
//
//     private String roleDescription;
//
//
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name="urlResource_id")
//     @ToString.Exclude
//     private UrlResource urlResource;
//
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name="user_account_id")
//     @ToString.Exclude
//     private UserAccount userAccount;
// }
