package com.yu.model.dto.postthumb;/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:28
 * @Description:com.yu.model.dto
 * @version:1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName PostThumbAddRequest
 * @Description // 帖子点赞请求
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@Data
public class PostThumbAddRequest implements Serializable {

    /**
     * 帖子 id
     */
    private Long postId;

    private static final long serialVersionUID = 1L;
}

 