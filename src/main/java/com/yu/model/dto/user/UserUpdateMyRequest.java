package com.yu.model.dto.user;/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:34
 * @Description:com.yu.model.dto.user
 * @version:1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserUpdateMyRequest
 * @Description // 用户更新个人信息请求
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@Data
public class UserUpdateMyRequest implements Serializable {

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 简介
     */
    private String userProfile;

    private static final long serialVersionUID = 1L;
}
