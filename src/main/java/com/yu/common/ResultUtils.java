package com.yu.common;/**
 * @Author:zhoayu
 * @Date:2024/11/3 22:12
 * @Description:com.yu.common
 * @version:1.0
 */

import co.elastic.clients.elasticsearch.xpack.usage.Base;

/**
 * @ClassName ResultUtils
 * @Description // 返回响应工具类
 * @Author zhaoyu
 * @Date 2024/11/3
 */
public class ResultUtils {

    /**
     * 返回成功响应
     * */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 返回失败响应
     * */
    public static BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse(errorCode);
    }

    /**
     * 返回失败响应
     */
    public static BaseResponse error(int code, String message) {
        return new BaseResponse(code, null, message);
    }

    /**
     * 返回失败响应
     * */
    public static BaseResponse error(ErrorCode errorCode, String message){
        return new BaseResponse(errorCode.getCode(), null, message);
    }
}

 