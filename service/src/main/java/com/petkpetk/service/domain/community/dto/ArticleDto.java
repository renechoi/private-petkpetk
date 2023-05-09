package com.petkpetk.service.domain.community.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
	private String rawHashtags;
	private List<MultipartFile> rawImages = new ArrayList<>();
	private List<ArticleImageDto> articleImages;
	private CategoryType categoryType;
	private LocalDateTime createdAt;

	public static ArticleDto from(ArticlePostRequest articlePostRequest, UserAccountDto userAccountDto) {
		ArticleDto articleDto = EntityAndDtoConverter.convertToDto(articlePostRequest, ArticleDto.class);
		articleDto.setUserAccountDto(userAccountDto);
		return articleDto;
	}

	public static ArticleDto from(Article article, List<MultipartFile> rawImages) {
		ArticleDto articleDto = EntityAndDtoConverter.convertToDto(article, ArticleDto.class);
		articleDto.setUserAccountDto(UserAccountDto.from(article.getUserAccount()));
		articleDto.setHashtagDtos(article.getHashtags().stream()
			.map(HashtagDto::from).collect(Collectors.toSet()));
		articleDto.setArticleImages(
			article.getArticleImages().stream().map(ArticleImageDto::from).collect(Collectors.toList()));

		articleDto.getRawImages().addAll(rawImages);
		return articleDto;
	}

	public Article toEntity(UserAccount userAccount, List<ArticleImage> articleImages) {
		Article article = EntityAndDtoConverter.convertToEntity(this, Article.class);
		article.setUserAccount(userAccount);
		if(articleImages!=null) article.addImages(articleImages);
		article.addHashtags(this.getRawHashtags());
		return article;
	}

	public static ArticleDto fromEntity(Article article) {
		return EntityAndDtoConverter.convertToDto(article, ArticleDto.class);
	}

	public Article toEntity() {
		Article article = EntityAndDtoConverter.convertToEntity(this, Article.class);
		return article;
	}
}
