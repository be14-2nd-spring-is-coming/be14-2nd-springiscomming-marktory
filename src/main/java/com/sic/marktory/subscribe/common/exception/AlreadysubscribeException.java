package com.sic.marktory.subscribe.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)  // 409 상태 코드 반환
public class AlreadysubscribeException extends RuntimeException {
    public AlreadysubscribeException(String message) {
        super(message);
    }
}
