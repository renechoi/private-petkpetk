package com.petkpetk.service.config.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.petkpetk.service.common.PetkpetkImage;
import com.petkpetk.service.common.PetkpetkRawImage;
import com.petkpetk.service.common.StatusCode;
import com.petkpetk.service.config.exception.PetkpetkServerException;
import com.petkpetk.service.config.properties.LocalProperty;
import com.petkpetk.service.domain.shopping.exception.ImageUploadFailureException;

@Component
public class ImageLocalRepository<T extends PetkpetkImage> {

	public void save(T petkpetkImage, MultipartFile rawImage) {
		try {
			rawImage.transferTo(new File(petkpetkImage.getImageUrl().replace("/images/item/", getSystemStorage())));
		} catch (IOException e) {
			throw new ImageUploadFailureException();
		}
	}



	public void deleteFiles(List<T> itemImages) {
		itemImages.forEach(this::delete);
	}

	public void delete(T petkpetkImage) {
		new File(petkpetkImage.getImageUrl().replace("/images/item/", getSystemStorage())).delete();
	}


	public MultipartFile findByPetkpetkImage(T petkpetkImage) {
		try {
			Path path = Paths.get(petkpetkImage.getImageUrl().replace( "/images/item/", getSystemStorage()));
			byte[] content = Files.readAllBytes(path);
			String contentType = Files.probeContentType(path);
			return new PetkpetkRawImage(petkpetkImage.getImageUrl(), path.getFileName().toString(), contentType, content);
		} catch (IOException e) {
			throw new PetkpetkServerException(StatusCode.LOCAL_IMAGE_CONVERTING_FAILURE);
		}
	}









	public String saveFiles(String uploadPath, String originalFileName, byte[] fileData) throws
		IOException {
		UUID uuid = UUID.randomUUID();
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
		String savedFileName = uuid.toString() + extension;
		String fileUploadFullUrl = uploadPath + "/" + savedFileName;

		Files.write(Paths.get(fileUploadFullUrl), fileData);
		return savedFileName;
	}

	public void deleteFile(String filePath, String originalImageName) {
		Optional.ofNullable(originalImageName)
			.filter(name -> !name.isEmpty())
			.map(name -> new File(filePath + "/" + name))
			.filter(File::exists)
			.ifPresent(File::delete);

	}

	private String getSystemStorage() {
		return LocalProperty.getInstance().getItemLocalStorage();
	}

	private String getLocalPath() {
		String uploadPath = LocalProperty.getInstance().getItemLocalStorage(); // WebMvcConfig에서 설정한 경로
		return uploadPath.substring(uploadPath.lastIndexOf("/")); // 마지막 / 뒤의 경로 반환
	}


}


