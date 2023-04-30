package com.petkpetk.service.domain.community.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.petkpetk.service.domain.community.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HashtagDto {

	private Long id;
	private String hashTagName;
	private Set<Article> articles = new LinkedHashSet<>();

}
