package com.petkpetk.service.common.controller.user;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.petkpetk.service.domain.shopping.dto.review.ReviewImageDto;
import com.petkpetk.service.domain.shopping.dto.review.request.ReviewRegisterRequest;
import com.petkpetk.service.domain.shopping.dto.review.response.ReviewResponse;
import com.petkpetk.service.domain.shopping.service.item.ItemService;
import com.petkpetk.service.domain.shopping.service.review.ReviewService;
import com.petkpetk.service.domain.user.dto.request.UserUpdateRequest;
import com.petkpetk.service.domain.user.dto.security.UserAccountPrincipal;
import com.petkpetk.service.domain.user.service.UserAccountService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/my-page/")
public class UserMyPageController {

	private final UserAccountService userAccountService;
	private final ReviewService reviewService;
	private final ItemService itemService;
	@PostMapping("/update")
	public String update(UserUpdateRequest userUpdateRequest, @RequestParam("isProfileDeleted") Boolean isProfileDeleted) {
		userAccountService.update(userUpdateRequest, isProfileDeleted);
		return "redirect:/user/my-page/information";
	}

	@PostMapping("/password/update")
	public String updatePassword(UserUpdateRequest userUpdateRequest) {
		userAccountService.updatePassword(userUpdateRequest);
		return "redirect:/user/my-page/information";
	}

	@PostMapping("/delete")
	public String delete(@AuthenticationPrincipal UserAccountPrincipal userAccountPrincipal) {
		userAccountService.delete(userAccountPrincipal.toDto());
		return "redirect:/";
	}

	@GetMapping("/information")
	public String informationView(Model model, @AuthenticationPrincipal UserAccountPrincipal userAccountPrincipal) {
		model.addAttribute("userAccount", userAccountService.getUserUpdateRequestView(userAccountPrincipal));
		return "my-page/user/userMyPage";
	}

	@GetMapping("/reviewHistory")
	public String reviewHistory(Model model, Authentication authentication) {
		String email = authentication.getName();
		List<ReviewResponse> reviewList = reviewService.getUserReviewList(email);
		System.out.println("====================== reviewList = " + reviewList);

		model.addAttribute("reviewList", reviewList);
		model.addAttribute("newReview", new ReviewRegisterRequest());

		return "my-page/user/userReviewHistory";
	}

	@PostMapping("/modify/{itemId}/{reviewId}")
	public String modifyReview(@PathVariable Long itemId,
		@PathVariable Long reviewId,
		ReviewRegisterRequest reviewRegisterRequest,
		@RequestParam("images") List<MultipartFile> rawImages,
		@RequestParam("imageNames") List<String> imageNames,
		@RequestParam(value = "uniqueImageNames", required = false) List<String> uniqueImageNames
	) {

		for (MultipartFile imagename : rawImages) {
			System.out.println("imagename.getOriginalFilename() = " + imagename.getOriginalFilename());
			System.out.println("imagename.getName() = " + imagename.getName());
			System.out.println("=====================================================");
		}

		System.out.println("rawImages = " + rawImages);
		System.out.println("uniqueImageNames = " + uniqueImageNames);

		reviewRegisterRequest.setImages(rawImages);
		System.out.println("reviewRegisterRequest = " + reviewRegisterRequest);

		IntStream.range(0, imageNames.size())
			.filter(i -> !imageNames.get(i).equals("첨부파일"))
			.forEach(i -> {
					if (uniqueImageNames != null) {
						reviewRegisterRequest.getReviewImageDtos()
							.add(ReviewImageDto.of(imageNames.get(i), uniqueImageNames.get(i)));
					} else{
						reviewRegisterRequest.getReviewImageDtos()
							.add(new ReviewImageDto());
					}
				}
			);
		reviewService.modifyReview(reviewRegisterRequest, reviewId);

		return "redirect:/user/my-page/reviewHistory";
	}

	@PostMapping("/delete/{itemId}/{reviewId}")
	public String deleteReview(@PathVariable Long itemId, @PathVariable Long reviewId) {
		System.out.println("itemId = " + itemId);
		System.out.println("reviewId = " + reviewId);
		reviewService.deleteReview(reviewId);
		return "redirect:/user/my-page/reviewHistory";
	}
}
