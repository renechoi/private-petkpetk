package com.petkpetk.service.domain.community.dto.request;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.petkpetk.service.common.CategoryType;
import com.petkpetk.service.config.converter.EntityAndDtoConverter;
import com.petkpetk.service.domain.community.dto.ArticleDto;
import com.petkpetk.service.domain.community.dto.ArticleImageDto;
import com.petkpetk.service.domain.community.dto.HashtagDto;
import com.petkpetk.service.domain.user.dto.UserAccountDto;

import lombok.Data;

@Data
public class ArticlePostRequest {

	private String title;
	private String content;

	private String rawHashtags;
	private List<MultipartFile> images = new ArrayList<>();

	private Set<ArticleImageDto> articleImageDtos;

	private CategoryType categoryType;

	public ArticleDto toDto(UserAccountDto userAccountDto) {
		ArticleDto articleDto = EntityAndDtoConverter.convertToDto(this, ArticleDto.class);
		articleDto.setUserAccountDto(userAccountDto);
		return articleDto;
	}
}
