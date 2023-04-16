package com.petkpetk.service.domain.user.entity.notuse;// package com.petkpetk.service.domain.user.entity.notuse;
//
// import java.io.Serializable;
// import java.util.LinkedHashSet;
// import java.util.Objects;
// import java.util.Set;
//
// import javax.persistence.CollectionTable;
// import javax.persistence.Column;
// import javax.persistence.ElementCollection;
// import javax.persistence.Entity;
// import javax.persistence.EnumType;
// import javax.persistence.Enumerated;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Index;
// import javax.persistence.JoinColumn;
// import javax.persistence.Table;
//
// import com.petkpetk.service.common.AuditingFields;
// import com.petkpetk.service.config.security.PasswordEncoderConfig;
// import com.petkpetk.service.common.RoleType;
//
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;
//
// @Getter
// @Setter
// @ToString(callSuper = true)
// @NoArgsConstructor()
// @Table(name = "user_account2",
// 	indexes = {
// 		@Index(columnList = "email"),
// 		@Index(columnList = "createdAt"),
// 		@Index(columnList = "createdBy")})
// @Entity
// public class UserAccount2 extends AuditingFields implements Serializable {
//
// 	@Id
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	private Long id;
//
// 	private String name;
//
// 	@Column(unique = true)
// 	private String email;
//
// 	private String password;
//
// 	private String address;
//
// 	@ElementCollection(targetClass = RoleType.class, fetch = FetchType.EAGER)
// 	@CollectionTable(name = "user_account2_roles", joinColumns = @JoinColumn(name = "user_account2_id"))
// 	@Enumerated(EnumType.STRING)
// 	private Set<RoleType> roles = new LinkedHashSet<>();
//
//
// 	private UserAccount2(String name, String email, String password, String address, Set<RoleType> roleTypes) {
// 		this.name = name;
// 		this.email = email;
// 		this.password = password;
// 		this.address = address;
// 		this.roles = roleTypes;
// 	}
//
//
// 	@Override
// 	public boolean equals(Object that) {
// 		if (this == that) {
// 			return true;
// 		}
// 		if (!(that instanceof UserAccount2)) {
// 			return false;
// 		}
// 		return this.getId() != null && this.getId().equals(((UserAccount2)that).getId());
// 	}
//
// 	@Override
// 	public int hashCode() {
// 		return Objects.hash(this.getId());
// 	}
// }