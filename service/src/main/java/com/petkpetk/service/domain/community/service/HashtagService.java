package com.petkpetk.service.domain.community.service;

import org.springframework.stereotype.Service;

import com.petkpetk.service.domain.community.entity.Hashtag;
import com.petkpetk.service.domain.community.repository.HashtagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HashtagService {
	private final HashtagRepository hashtagRepository;

	// public void deleteHashtagByArticle(Long hashtagId) {
	// 	Hashtag hashtag = hashtagRepository.getReferenceById(hashtagId);
	// 	if ( hashtag.getArticles().stream().allMatch(articleService::isArticleDeleted) ) {
	// 		hashtagRepository.delete(hashtag);
	// 	}
	//
	// }
}
