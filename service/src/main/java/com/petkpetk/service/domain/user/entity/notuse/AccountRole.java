package com.petkpetk.service.domain.user.entity.notuse;// package com.petkpetk.service.domain.user.entity.notuse;
//
// import lombok.*;
//
// import javax.persistence.*;
// import java.io.Serializable;
//
// import com.petkpetk.service.domain.user.entity.notuse.Role;
//
// @Entity
// @Table(name = "account_roles")
// @Getter
// @Setter
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// @EqualsAndHashCode(of = {"account", "role"})
// public class AccountRole implements Serializable {
//
//     @Id
//     @GeneratedValue
//     @Column(name = "account_role_id")
//     private Long id;
//
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "account_id")
//     private Account account;
//
//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "role_id")
//     private Role role;
// }
