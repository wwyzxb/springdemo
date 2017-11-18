package com.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author Vincent
 * @Date 2017/11/18 11:39
 */
@AllArgsConstructor
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    @Getter
    @Setter
    private int code;
    @Getter
    @Setter
    private String message;

    public BusinessException(CommonMessage code) {
        this.code = code.getCode();
        this.message = code.getMessage();
    }
}
