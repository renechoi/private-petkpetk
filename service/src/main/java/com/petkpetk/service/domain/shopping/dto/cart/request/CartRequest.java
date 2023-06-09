package com.petkpetk.service.domain.shopping.dto.cart.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CartRequest {

	@NotNull(message = "상품 아이디는 필수 입력 값 입니다")
	private Long itemId;

	@Min(value = 1, message = "최소 1개 이상 담아주세요")
	private Long itemCount;

}
