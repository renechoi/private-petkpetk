package com.petkpetk.service.domain.user.service.notuse;// package com.petkpetk.service.domain.user.service.notuse;
//
// import java.io.FileInputStream;
// import java.io.IOException;
//
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.multipart.MultipartFile;
//
// public class filecontrollertest {
// 	@GetMapping("/image")
// 	public String getImage(Model model) throws IOException {
// 		File file = new File("path/to/image.jpg");
// 		MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
// 			ContentType.APPLICATION_OCTET_STREAM.toString(), new FileInputStream(file));
// 		model.addAttribute("imageFile", multipartFile);
// 		return "image";
// 	}
//
// }
