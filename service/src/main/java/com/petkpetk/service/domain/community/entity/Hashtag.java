package com.petkpetk.service.domain.community.entity;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.petkpetk.service.common.AuditingFields;
import com.petkpetk.service.domain.community.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
	@Index(columnList = "hashtagName", unique = true),
	@Index(columnList = "createdAt"),
	@Index(columnList = "createdBy")
})
@NoArgsConstructor
@Entity
public class Hashtag extends AuditingFields {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hashtag_id", length = 10)
	private Long id;
	private String hashTagName;

	@ToString.Exclude
	@ManyToMany(mappedBy = "hashtags")
	private Set<Article> articles = new LinkedHashSet<>();

	public Hashtag(String hashTagName) {
		this.hashTagName = hashTagName;
	}

	public static Hashtag of(String hashtagName) {
		return new Hashtag(hashtagName);
	}
}
