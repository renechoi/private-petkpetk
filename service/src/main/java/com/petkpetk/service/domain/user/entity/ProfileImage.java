package com.petkpetk.service.domain.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.petkpetk.service.common.PetkpetkImage;
import com.petkpetk.service.domain.shopping.entity.item.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProfileImage implements PetkpetkImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profile_image_id")
	private Long id;

	private String uniqueName;

	private String originalName;

	private String imageUrl;

	private String representativeImageYn = "N";

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_account_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ToString.Exclude
	private UserAccount userAccount;

	public ProfileImage(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public static ProfileImage of(String imageUrl) {
		return new ProfileImage(imageUrl);
	}

	public void mapWith(UserAccount userAccount) {
		if (this.userAccount == null) {
			this.userAccount = userAccount;
		}
	}

}
