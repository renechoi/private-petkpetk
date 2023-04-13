package com.petkpetk.service.domain.user.entity.notuse;//
// package com.petkpetk.service.domain.user.entity.notuse;
//
// import lombok.*;
//
// import javax.persistence.*;
// import java.io.Serializable;
// import java.util.LinkedHashSet;
// import java.util.Set;
//
// import com.petkpetk.service.domain.user.entity.notuse.Role;
//
// @Entity
// @Table(name = "resource")
// @NoArgsConstructor
// @AllArgsConstructor
// @Getter
// @Setter
// public class UrlResource implements Serializable {
//
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//
//     private String resourceName;
//
//     private String httpMethod;
//
//     private int orderNum;
//
//     private String resourceType;
//
//     @ToString.Exclude
//     @OneToMany(mappedBy = "urlResource", cascade = CascadeType.ALL)
//     private Set<Role> roles = new LinkedHashSet<>();
//
//
// }
