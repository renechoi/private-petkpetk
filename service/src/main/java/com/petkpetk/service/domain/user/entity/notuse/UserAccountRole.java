package com.petkpetk.service.domain.user.entity.notuse;// package com.petkpetk.service.domain.user.entity;
//
// import java.io.Serializable;
//
// import javax.persistence.Entity;
// import javax.persistence.EnumType;
// import javax.persistence.Enumerated;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;
//
// import com.petkpetk.service.common.RoleType;
//
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
//
// @Getter
// @Setter
// @NoArgsConstructor
// @Entity
// @Table(name = "user_account_role")
// public class UserAccountRole implements Serializable {
//
// 	@Id
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	private Long id;
//
// 	@ManyToOne(fetch = FetchType.LAZY)
// 	@JoinColumn(name = "user_account_id", nullable = false)
// 	private UserAccount userAccount;
//
// 	@Enumerated(EnumType.STRING)
// 	private RoleType roleType;
//
// 	private UserAccountRole(UserAccount userAccount, RoleType roleType) {
// 		this.userAccount = userAccount;
// 		this.roleType = roleType;
// 	}
//
// 	public static UserAccountRole of(UserAccount userAccount, RoleType roleType) {
// 		return new UserAccountRole(userAccount, roleType);
// 	}
// }
