package com.demo.exception;

/**
 * @Author Vincent
 * @Date 2017/11/18 11:39
 */
public class BusinessException extends RuntimeException {
    private int code;
    private String message;

    public BusinessException(CommonMessage code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
