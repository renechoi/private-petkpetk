package com.petkpetk.service.domain.shopping.dto.cart;

import java.awt.*;
import java.util.List;

import com.petkpetk.service.domain.shopping.entity.cart.CartItem;
import com.petkpetk.service.domain.shopping.entity.item.ItemImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {

	private Long id;
	private Long itemId;
	private String itemName;
	private List<ItemImage> images;;
	private Long price;
	private Long cartItemCount;

	public static CartItemDto from(CartItem cartItem) {
		return new CartItemDto(
			cartItem.getId(),
			cartItem.getItem().getId(),
			cartItem.getItem().getItemName(),
			cartItem.getItem().getImages(),
			cartItem.getItem().getPrice(),
			cartItem.getCartItemCount()
		);
	}

	public Long getPrice(){
		return price * cartItemCount;
	}
}
