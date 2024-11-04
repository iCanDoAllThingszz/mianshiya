package com.yu.exception;/**
 * @Author:zhoayu
 * @Date:2024/11/4 12:04
 * @Description:com.yu.exception
 * @version:1.0
 */

import com.yu.common.ErrorCode;

/**
 * @ClassName BusinessException
 * @Description // 自定义异常类
 * @Author zhaoyu
 * @Date 2024/11/4
 */
public class BusinessException extends RuntimeException {

    /**
     * 错误码
     */
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}

 