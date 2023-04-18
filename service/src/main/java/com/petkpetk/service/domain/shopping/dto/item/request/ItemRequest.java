package com.petkpetk.service.domain.shopping.dto.item.request;

import java.util.ArrayList;
import java.util.List;

import com.petkpetk.service.domain.shopping.constant.ItemStatus;
import com.petkpetk.service.domain.shopping.dto.item.ItemImageDto;
import com.petkpetk.service.domain.shopping.entity.item.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data()
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {

	private Long id;

	private String itemName;

	private Long price;

	private Long itemAmount;

	private  String itemDetail;

	private ItemStatus itemStatus;

	private List<ItemImageDto> itemImageDtos = new ArrayList<>();

	private List<Long> itemImageIds = new ArrayList<>();


	public static ItemRequest of(Item entity, List<ItemImageDto> itemImageDtos, List<Long> itemImageIds) {
		return new ItemRequest(
			entity.getId(),
			entity.getItemName(),
			entity.getPrice(),
			entity.getItemAmount(),
			entity.getItemDetail(),
			entity.getItemStatus(),
			itemImageDtos,
			itemImageIds
		);
	}

}
