package com.petkpetk.service.domain.shopping.dto.cart;

import com.petkpetk.service.config.converter.EntityAndDtoConverter;
import com.petkpetk.service.domain.shopping.entity.cart.Cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDetailDto {

	private Long cartItemId;

	private String itemName;

	private Long price;

	private Long itemCount;

	private String imageUrl;

	public CartDetailDto(Long cartItemId, String itemName, Long price, Long itemCount, String imageUrl) {
		this.cartItemId = cartItemId;
		this.itemName = itemName;
		this.price = price;
		this.itemCount = itemCount;
		this.imageUrl = imageUrl;
	}
}
