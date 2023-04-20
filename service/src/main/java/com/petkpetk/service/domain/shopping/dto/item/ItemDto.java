package com.petkpetk.service.domain.shopping.dto.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.petkpetk.service.config.converter.EntityAndDtoConverter;
import com.petkpetk.service.domain.shopping.constant.ItemStatus;
import com.petkpetk.service.domain.shopping.dto.item.request.ItemRegisterRequest;
import com.petkpetk.service.domain.shopping.entity.item.Item;
import com.petkpetk.service.domain.shopping.entity.item.ItemImage;
import com.petkpetk.service.domain.user.entity.UserAccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

	private Long id;

	private String itemName;

	private Long price;

	private Long itemAmount;

	private String itemDetail;

	private ItemStatus itemStatus;

	private List<MultipartFile> rawImages = new ArrayList<>();
	private UserAccount userAccount;

	private List<ItemImageDto> itemImageDtos = new ArrayList<>();

	private List<Long> itemImageIds = new ArrayList<>();

	public ItemDto(String itemName, Long price, Long itemAmount, String itemDetail, ItemStatus itemStatus,
		List<MultipartFile> rawImages,
		UserAccount userAccount) {
		this.itemName = itemName;
		this.price = price;
		this.itemAmount = itemAmount;
		this.itemDetail = itemDetail;
		this.itemStatus = itemStatus;
		this.rawImages = rawImages;
		this.userAccount = userAccount;
	}

	public static ItemDto of(String itemName, Long price, Long itemAmount, String itemDetail, ItemStatus itemStatus,
		List<MultipartFile> rawImages, UserAccount userAccount) {
		return new ItemDto(itemName, price, itemAmount, itemDetail, itemStatus, rawImages, userAccount);
	}



	public static ItemDto from(Item item){
		return EntityAndDtoConverter.convertToDto(item, ItemDto.class);
	}

	//
	// /** TODO : 잘못된 방식 !!!
	//  * 이 문제는 Item 객체가 영속 상태가 되기 전에 ItemImage 객체를 저장하려고 할 때 발생하는 것입니다. 즉, ItemImage 객체가 저장될 때 item 속성이 null로 설정되기 때문에 item_id 컬럼에는 null 값이 저장됩니다.
	//  *
	//  * 해결책으로는 다음 두 가지 방법이 있습니다.
	//  *
	//  * Item 객체를 영속 상태로 만들고 ItemImage 객체를 저장합니다.
	//  * 이 방법은 ItemImage 객체를 저장하기 전에 Item 객체를 저장하고 영속 상태로 만들어야 합니다.
	//  * 이렇게 하면 ItemImage 객체에서 Item 객체를 참조할 때 null 값을 가리키지 않게 됩니다.
	//  * 따라서 ItemImage 객체가 영속성 컨텍스트에 존재하는 Item 객체를 참조할 수 있게 됩니다.
	//  * @param images
	//  * @return
	//  */
	//
	public Item toEntity(List<ItemImage> images) {
		return Item.of(
			this.itemName,
			this.price,
			this.itemAmount,
			this.itemDetail,
			this.itemStatus,
			images,
			this.userAccount
		);
	}

	public Item toEntity() {
		return Item.of(
			this.itemName,
			this.price,
			this.itemAmount,
			this.itemDetail,
			this.itemStatus,
			null,
			this.userAccount
		);
	}
	//
	// public Item toEntity() {
	// 	return Item.of(
	// 		this.itemName,
	// 		this.price,
	// 		this.itemAmount,
	// 		this.itemDetail,
	// 		this.itemStatus,
	// 		this.userAccount
	// 	);
	// }

	public static ItemDto from(ItemRegisterRequest itemRegisterRequest, UserAccount userAccount) {
		return new ItemDto(
			itemRegisterRequest.getItemName(),
			itemRegisterRequest.getPrice(),
			itemRegisterRequest.getItemAmount(),
			itemRegisterRequest.getItemDetail(),
			itemRegisterRequest.getItemStatus(),
			itemRegisterRequest.getImages(),
			userAccount
		);
	}
}
