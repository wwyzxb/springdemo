package com.demo.controller;

import com.demo.exception.BusinessException;
import com.demo.exception.CommonMessage;
import com.demo.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

/**
 * @Author Vincent
 * @Date 2017/11/18 18:22
 */
@ControllerAdvice
public class ExceptionHandleController extends ExceptionHandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandleController.class);

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public String processBusinessException(BusinessException ex) {
        logger.error(ex.getMessage(), ex);
        return Result.returnFailResult(ex);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public String processException(Throwable ex) {
        logger.error(ex.getMessage(), ex);
        if (ex.getClass().getPackage().getName().startsWith("org.springframework.web")) {
            return Result.returnFailResult(ex.getMessage());
        }
        return Result.returnFailResult(new BusinessException(CommonMessage.SystemMessage.ERROR_SYSTEM));
    }
}
