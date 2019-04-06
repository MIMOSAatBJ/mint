package com.gto.handler;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handle(HttpServletRequest request,
                         Exception exception) {
        System.out.println("GlobalExceptionHandler");
        return null;
    }
}
