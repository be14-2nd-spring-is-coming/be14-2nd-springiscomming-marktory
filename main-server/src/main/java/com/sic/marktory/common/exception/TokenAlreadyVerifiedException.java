package com.sic.marktory.common.exception;

/* 설명. 커스텀 예외 3. 이미 인증이 완료된 이메일일 때, 여러번의 요청을 보낼 때 */
public class TokenAlreadyVerifiedException extends Exception{
    public TokenAlreadyVerifiedException(String message) {
        super(message);
    }
}
