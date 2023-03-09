package com.example.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : jinye
 * @date : 2023/3/2 11:26
 * springmvc异常处理器
 */
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 拦截所有异常信息
     * @param ex
     */
    @ExceptionHandler
    public R doException(Exception ex){
        ex.printStackTrace();
        return new R("服务器故障");
    }

}
