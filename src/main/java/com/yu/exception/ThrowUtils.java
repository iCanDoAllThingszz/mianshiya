package com.yu.exception;/**
 * @Author:zhoayu
 * @Date:2024/11/4 12:09
 * @Description:com.yu.exception
 * @version:1.0
 */

import com.yu.common.ErrorCode;

/**
 * @ClassName ThrowUtils
 * @Description // 抛异常工具类
 * @Author zhaoyu
 * @Date 2024/11/4
 */
public class ThrowUtils {

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param runtimeException
     */
    public static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param errorCode
     */
    public static void throwIf(boolean condition, ErrorCode errorCode) {
        throwIf(condition, new BusinessException(errorCode));
    }

    /**
     * 条件成立则抛异常
     *
     * @param condition
     * @param errorCode
     * @param message
     */
    public static void throwIf(boolean condition, ErrorCode errorCode, String message) {
        throwIf(condition, new BusinessException(errorCode, message));
    }
}

 