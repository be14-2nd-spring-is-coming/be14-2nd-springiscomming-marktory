package com.sic.marktory.comment.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedCommentAccessException extends RuntimeException {
    public UnauthorizedCommentAccessException(String message) {
        super(message);
    }
}
