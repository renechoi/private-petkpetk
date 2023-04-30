package com.petkpetk.service.domain.community.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.petkpetk.service.domain.community.entity.Article;
import com.petkpetk.service.domain.community.entity.ArticleComment;
import com.petkpetk.service.domain.user.dto.UserAccountDto;
import com.petkpetk.service.domain.user.entity.UserAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

	private Long id;

	private ArticleDto articleDto;

	private UserAccountDto userAccountDto;

	private String content;
	private Long parentCommentId;

	private Set<ArticleCommentDto> childCommentDtos = new LinkedHashSet<>();

}
