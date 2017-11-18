package com.demo.utils;

import com.demo.exception.BusinessException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Author Vincent
 * @Date 2017/11/18 18:30
 */
public class Result<E> {
    private static final int FAIL = 999;
    private static final int SUCCESS = 666;
    private static final String SUCCESS_MSG = "success";


    private final static Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static String returnFailResult(BusinessException ex) {
        return gson.toJson(new Result<String>(ex.getCode(), ex.getMessage(), ""));
    }

    public static String returnFailResult(String message) {
        return gson.toJson(new Result<String>(FAIL, message, ""));
    }

    public static <T> String returnSuccessResult(T data) {
        return gson.toJson(new Result<T>(SUCCESS, SUCCESS_MSG, data));
    }

    private int code;
    private String message;
    private E data;

    public Result(int code, String message, E data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
