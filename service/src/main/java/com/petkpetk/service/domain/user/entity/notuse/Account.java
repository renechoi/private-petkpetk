package com.petkpetk.service.domain.user.entity.notuse;// package com.petkpetk.service.domain.user.entity.notuse;
//
// import lombok.*;
//
// import javax.persistence.*;
// import java.io.Serializable;
// import java.util.HashSet;
// import java.util.Set;
//
// @Entity
// @Data
// @ToString(exclude = {"userRoles"})
// @Builder
// @EqualsAndHashCode(of = "id")
// @NoArgsConstructor
// @AllArgsConstructor
// public class Account implements Serializable {
//
//     @Id
//     @GeneratedValue
//     private Long id;
//
//     @Column
//     private String username;
//
//     @Column
//     private String email;
//
//     @Column
//     private int age;
//
//     @Column
//     private String password;
//
//     @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
//     private Set<AccountRole> accountRoles = new HashSet<>();
// }
//
