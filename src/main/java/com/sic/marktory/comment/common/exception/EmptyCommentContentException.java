package com.sic.marktory.comment.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyCommentContentException extends RuntimeException {
    public EmptyCommentContentException(String message) {
        super(message);
    }
}
