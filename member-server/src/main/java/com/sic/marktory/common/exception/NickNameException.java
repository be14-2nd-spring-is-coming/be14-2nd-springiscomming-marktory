package com.sic.marktory.common.exception;

/* 설명. 닉네임이 중복이 일어났을 때, 발생하는 예외 */
public class NickNameException extends Exception {
    public NickNameException(String message) {
        super(message);
    }
}
