package com.yu.model.dto.user;/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:31
 * @Description:com.yu.model.dto.user
 * @version:1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserLoginRequest
 * @Description // 用户登陆请求
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;
}

 