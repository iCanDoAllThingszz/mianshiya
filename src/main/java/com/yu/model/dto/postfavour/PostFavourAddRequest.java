package com.yu.model.dto.postfavour;/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:23
 * @Description:com.yu.model.dto.postfavour
 * @version:1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName PostFavourAddRequest
 * @Description // 帖子收藏/取消收藏请求
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@Data
public class PostFavourAddRequest implements Serializable {

    /**
     * 帖子 id
     */
    private Long postId;

    private static final long serialVersionUID = 1L;
}

 