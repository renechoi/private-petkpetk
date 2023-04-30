package com.petkpetk.service.domain.community.dto;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.petkpetk.service.common.CategoryType;
import com.petkpetk.service.config.converter.EntityAndDtoConverter;
import com.petkpetk.service.domain.community.dto.request.ArticlePostRequest;
import com.petkpetk.service.domain.community.entity.Article;
import com.petkpetk.service.domain.community.entity.ArticleImage;
import com.petkpetk.service.domain.user.dto.UserAccountDto;
import com.petkpetk.service.domain.user.entity.UserAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

	private Long id;

	private UserAccountDto userAccountDto;

	private String title;
	private String content;
	private Long hit;

	private Set<ArticleLikesDto> likeDtos;

	private Set<HashtagDto> hashtagDtos = new LinkedHashSet<>();

	private List<MultipartFile> rawImages = new ArrayList<>();

	private List<ArticleImage> articleImages;

	private CategoryType categoryType;


	public static ArticleDto from(ArticlePostRequest articlePostRequest, UserAccountDto userAccountDto) {
		ArticleDto articleDto = EntityAndDtoConverter.convertToDto(articlePostRequest, ArticleDto.class);
		articleDto.setUserAccountDto(userAccountDto);
		return articleDto;
	}

	public Article toEntity(UserAccount userAccount, List<ArticleImage> articleImages) {
		Article article = EntityAndDtoConverter.convertToEntity(this, Article.class);
		article.setUserAccount(userAccount);
		article.addImages(articleImages);
		return article;
	}

	public static ArticleDto fromEntity(Article article) {
		return EntityAndDtoConverter.convertToDto(article, ArticleDto.class);
	}

}
