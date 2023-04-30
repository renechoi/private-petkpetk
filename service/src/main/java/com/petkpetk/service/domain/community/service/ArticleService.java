package com.petkpetk.service.domain.community.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.petkpetk.service.config.converter.ImageConverter;
import com.petkpetk.service.config.file.ImageLocalRepository;
import com.petkpetk.service.domain.community.dto.ArticleDto;
import com.petkpetk.service.domain.community.entity.Article;
import com.petkpetk.service.domain.community.entity.ArticleImage;
import com.petkpetk.service.domain.community.entity.Hashtag;
import com.petkpetk.service.domain.community.exception.ArticleNotFoundException;
import com.petkpetk.service.domain.community.repository.ArticleImageRepository;
import com.petkpetk.service.domain.community.repository.ArticleRepository;
import com.petkpetk.service.domain.community.repository.HashtagRepository;
import com.petkpetk.service.domain.user.entity.UserAccount;
import com.petkpetk.service.domain.user.repository.UserAccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {
	private final ArticleRepository articleRepository;
	private final UserAccountRepository userAccountRepository;
	private final ArticleImageRepository articleImageRepository;
	private final ImageLocalRepository<ArticleImage> articleImageLocalRepository;
	private final HashtagService hashtagService;
	private final HashtagRepository hashtagRepository;

	public void saveArticle(ArticleDto articleDto) {
		UserAccount userAccount = userAccountRepository.findByEmail(articleDto.getUserAccountDto().getEmail())
			.orElseThrow(ArticleNotFoundException::new);

		List<ArticleImage> images = ImageConverter.of(ArticleImage::from).convertToImages(articleDto.getRawImages());

		articleRepository.save(articleDto.toEntity(userAccount, images));

		uploadImages(articleDto, images);
	}

	public void deleteArticle(Long articleId) {
		Article article = articleRepository.getReferenceById(articleId);
		article.setDeletedYn("Y");
		articleRepository.flush();

		deleteHashtagsByArticle(article);
		deleteImagesByArticle(articleId);
	}

	private void uploadImages(ArticleDto articleDto, List<ArticleImage> images) {
		IntStream.range(0, images.size())
			.forEach(
				image -> articleImageLocalRepository.save(images.get(image), articleDto.getRawImages().get(image)));
	}

	private void deleteHashtagsByArticle(Article article) {
		Set<Long> hashtagIds = article.getHashtags()
			.stream()
			.map(Hashtag::getId)
			.collect(Collectors.toUnmodifiableSet());
		hashtagIds.forEach(this::deleteHashtagByArticle);
	}

	private void deleteHashtagByArticle(Long hashtagId) {
		Hashtag hashtag = hashtagRepository.getReferenceById(hashtagId);
		if (hashtag.getArticles().stream().allMatch(this::isArticleDeleted)) {
			hashtagRepository.delete(hashtag);
		}
	}

	private boolean isArticleDeleted(Article article) {
		return articleRepository.getReferenceById(article.getId()).getDeletedYn().equals("Y");
	}

	private void deleteImagesByArticle(Long articleId) {
		List<ArticleImage> articleImages = articleImageRepository.findByArticleIdOrderByIdAsc(articleId);
		articleImages.forEach(articleImage -> articleImage.setDeletedYn("Y"));

		articleImageLocalRepository.deleteFiles(articleImages);
	}
}






