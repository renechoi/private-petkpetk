package com.petkpetk.service.domain.shopping.service.notuse;// package com.petkpetk.service.domain.shopping.service.notuse;// ItemController.java
//
// import java.io.File;
// import java.io.IOException;
//
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.util.StringUtils;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.multipart.MultipartFile;
//
// @Controller
// public class ItemController {
//     @Value("${item.image.directory}")
//     private String itemImageDirectory;
//
//     @PostMapping("/items")
//     public String createItem(Item item) throws IOException {
//         MultipartFile imageFile = item.getImage();
//         String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
//
//         File directory = new File(itemImageDirectory);
//         if (!directory.exists()) {
//             directory.mkdirs();
//         }
//
//         File file = new File(directory, fileName);
//         imageFile.transferTo(file);
//
//         // Item 저장 로직 추가
//
//         return "redirect:/items";
//     }
// }
