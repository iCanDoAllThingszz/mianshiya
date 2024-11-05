package com.yu.model.dto.user;/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:32
 * @Description:com.yu.model.dto.user
 * @version:1.0
 */

import com.yu.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @ClassName UserQueryRequest
 * @Description // 用户查询请求
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 开放平台id
     */
    private String unionId;

    /**
     * 公众号openId
     */
    private String mpOpenId;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}

 