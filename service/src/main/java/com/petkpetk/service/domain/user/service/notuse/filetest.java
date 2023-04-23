package com.petkpetk.service.domain.user.service.notuse;// package com.petkpetk.service.domain.user.service.notuse;
//
// import java.io.FileInputStream;
// import java.io.IOException;
// import java.nio.file.Files;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.multipart.MultipartFile;
//
// import com.petkpetk.service.common.PetkpetkImage;
// import com.petkpetk.service.config.file.ImageLocalRepository;
//
// public class filetest {
//
// 	File file = new File("path/to/image.jpg");
// 	MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
// 		ContentType.APPLICATION_OCTET_STREAM.toString(), new FileInputStream(file));
//
//
//
// 	@Autowired
// 	private ImageLocalRepository<PetkpetkImage> imageLocalRepository;
//
// 	@GetMapping("/image")
// 	public String getImage(Model model) throws IOException {
// 		File file = new File("path/to/image.jpg");
// 		byte[] fileContent = Files.readAllBytes(file.toPath());
// 		String fileName = file.getName();
// 		MultipartFile multipartFile = new MockMultipartFile(fileName, fileName,
// 			ContentType.APPLICATION_OCTET_STREAM.toString(), fileContent);
// 		model.addAttribute("imageFile", multipartFile);
// 		return "image";
// 	}
//
//
// 	@PostMapping("/image")
// 	public String uploadImage(@RequestParam("file") MultipartFile file) {
// 		PetkpetkImage petkpetkImage = new PetkpetkImage();
// 		String imageUrl = "/images/item/" + imageLocalRepository.saveFiles(
// 			imageLocalRepository.getSystemStorage(), file.getOriginalFilename(), file.getBytes());
// 		petkpetkImage.setImageUrl(imageUrl);
// 		imageLocalRepository.save(petkpetkImage, file);
// 		return "redirect:/image";
// 	}
//
//
//
// }
