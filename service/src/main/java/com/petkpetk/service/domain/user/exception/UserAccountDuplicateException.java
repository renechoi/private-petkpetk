package com.petkpetk.service.domain.user.exception;

public class UserAccountDuplicateException extends RuntimeException{

    private static final String message = "이미 가입된 회원입니다";
    public UserAccountDuplicateException() {
        super(message);
    }

}
