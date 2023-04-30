package com.petkpetk.service.domain.community.dto;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.petkpetk.service.domain.community.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleImageDto {

	private Long id;

	private String uniqueName;

	private String originalName;

	private String imageUrl;

	private String representativeImageYn = "N";

	private ArticleDto articleDto;
}
