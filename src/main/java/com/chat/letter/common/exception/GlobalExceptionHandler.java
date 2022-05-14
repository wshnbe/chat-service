package com.chat.letter.common.exception;

import com.chat.letter.common.msg.ResultMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常拦截器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value=RuntimeException.class)
    @ResponseBody
    public Object exceptionHandler(Exception e){
        return ResultMessage.errorStr(e.getMessage());
    }
}
