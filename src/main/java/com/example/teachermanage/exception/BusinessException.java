package com.example.teachermanage.exception;

//自定义的运行时异常
public class BusinessException extends RuntimeException{
    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }
}
