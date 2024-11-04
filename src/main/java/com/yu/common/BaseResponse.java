package com.yu.common;/**
 * @Author:zhoayu
 * @Date:2024/11/3 22:02
 * @Description:com.yu.common
 * @version:1.0
 */


import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName BaseResponse
 * @Description // 通用返回类
 * @Author zhaoyu
 * @Date 2024/11/3
 */
@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data){
        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }

}

 