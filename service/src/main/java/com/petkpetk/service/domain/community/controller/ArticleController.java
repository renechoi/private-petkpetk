package com.petkpetk.service.domain.community.controller;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petkpetk.service.domain.community.dto.ArticleDto;
import com.petkpetk.service.domain.community.dto.request.ArticlePostRequest;
import com.petkpetk.service.domain.community.service.ArticleService;
import com.petkpetk.service.domain.user.dto.UserAccountDto;
import com.petkpetk.service.domain.user.dto.security.UserAccountPrincipal;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/community/article")
public class ArticleController {

	private final ArticleService articleService;

	@GetMapping("/post")
	public String postArticle(Model model) {
		model.addAttribute("article", new ArticlePostRequest());
		return "/community/article/post";
	}


	@PostMapping("/post")
	public String postArticle(
		@Valid ArticlePostRequest articlePostRequest,
		@AuthenticationPrincipal UserAccountPrincipal userAccountPrincipal
		){

		System.out.println("articlePostRequest = " + articlePostRequest);
		System.out.println("userAccountPrincipal = " + userAccountPrincipal);

		articleService.saveArticle(ArticleDto.from(articlePostRequest, UserAccountDto.from(userAccountPrincipal)));

		return "redirect:/";
	}

	@PostMapping("/{articleId}/delete")
	public String deleteArticle(@PathVariable Long articleId) {
		articleService.deleteArticle(articleId);

		return "redirect:/articles";
	}
}
