package com.petkpetk.service.domain.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petkpetk.service.domain.community.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {


}
