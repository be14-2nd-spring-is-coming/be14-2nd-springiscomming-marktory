package com.sic.marktory.comment.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CommentAlreadyDeletedException extends RuntimeException {
    public CommentAlreadyDeletedException(String message) {
        super(message);
    }
}
