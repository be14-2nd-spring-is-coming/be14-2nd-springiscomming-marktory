package com.sic.marktory.common.exception;

/* 설명. 커스텀 예외 2. 시간 안에 만료되었을 때 */
public class TokenExpiredException extends Exception {
    public TokenExpiredException(String message) {
        super(message);
    }
}
