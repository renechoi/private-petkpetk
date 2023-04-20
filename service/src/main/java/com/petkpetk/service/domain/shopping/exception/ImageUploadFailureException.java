package com.petkpetk.service.domain.shopping.exception;

import com.petkpetk.service.common.StatusCode;
import com.petkpetk.service.config.exception.PetkpetkServerException;

public class ImageUploadFailureException extends  PetkpetkServerException{

	private static final StatusCode statusCode = StatusCode.IMAGE_UPLOAD_FAILURE;

	public ImageUploadFailureException(){
		super(statusCode);
	}

	public ImageUploadFailureException(StatusCode statusCode) {
		super(statusCode);
	}

	public ImageUploadFailureException(StatusCode statusCode, String detailMessage) {
		super(statusCode, detailMessage);
	}


}
