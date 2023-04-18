package com.petkpetk.service.domain.shopping.repository.item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.petkpetk.service.domain.shopping.entity.item.ItemImage;
import com.petkpetk.service.domain.shopping.repository.querydsl.item.ItemImageRepositoryCustom;

public interface ItemImageRepository extends JpaRepository<ItemImage, Long>,
	QuerydslPredicateExecutor<ItemImage>, ItemImageRepositoryCustom {
	List<ItemImage> findByItemIdOrderByIdAsc(Long itemId);


}