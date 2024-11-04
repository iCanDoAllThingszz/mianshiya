package com.yu.exception;/**
 * @Author:zhoayu
 * @Date:2024/11/4 12:05
 * @Description:com.yu.exception
 * @version:1.0
 */

import com.yu.common.BaseResponse;
import com.yu.common.ErrorCode;
import com.yu.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description // 全局异常处理器
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@RestControllerAdvice
// 作用: @RestControllerAdvice是一个组合注解，结合了@ControllerAdvice和@ResponseBody的功能。
// 功能：它用于全局处理控制器中的异常，并将异常信息以JSON格式返回给客户端。@RestControllerAdvice会扫描所有使用@RequestMapping注解的方法，并应用其定义的异常处理逻辑。
@Slf4j
public class GlobalExceptionHandler {

    //作用：@ExceptionHandler注解用于定义方法来处理特定类型的异常。
    //功能：当控制器方法抛出指定类型的异常时，带有@ExceptionHandler注解的方法会被调用来处理该异常。比如在这段代码中：
    //@ExceptionHandler(BusinessException.class)：当抛出BusinessException时，businessExceptionHandler方法会被调用。
    //@ExceptionHandler(RuntimeException.class)：当抛出RuntimeException时，runtimeExceptionHandler方法会被调用。
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("BusinessException", e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse<?> runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException", e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR, "系统错误");
    }
}

 