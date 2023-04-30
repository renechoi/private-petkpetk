package com.petkpetk.service.domain.community.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.petkpetk.service.domain.community.entity.Article;
import com.petkpetk.service.domain.community.entity.ArticleComment;
import com.petkpetk.service.domain.user.dto.UserAccountDto;
import com.petkpetk.service.domain.user.entity.UserAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentDto {

	private Long id;

	private ArticleDto articleDto;

	private UserAccountDto userAccountDto;


	private String content;
	private Long parentCommentId;

	private Set<ArticleCommentDto> childComments = new LinkedHashSet<>();
}
