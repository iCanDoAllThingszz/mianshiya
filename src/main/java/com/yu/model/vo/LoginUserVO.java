package com.yu.model.vo;/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:52
 * @Description:com.yu.model.vo
 * @version:1.0
 */

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName LoginUserVO
 * @Description // 已登陆用户视图 - 返回给前端的VO对象
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@Data
public class LoginUserVO implements Serializable {

    /**
     * 用户 id
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}

 