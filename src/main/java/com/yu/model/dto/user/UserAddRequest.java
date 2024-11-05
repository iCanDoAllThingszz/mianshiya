package com.yu.model.dto.user;/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:30
 * @Description:com.yu.model.dto.user
 * @version:1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UserAddRequest
 * @Description // 用户创建请求
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@Data
public class UserAddRequest implements Serializable {

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 账号
     */
    private String userAccount;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户角色: user, admin
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}

 