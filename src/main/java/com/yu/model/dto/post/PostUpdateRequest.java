package com.yu.model.dto.post;/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:22
 * @Description:com.yu.model.dto.post
 * @version:1.0
 */

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PostUpdateRequest
 * @Description // 帖子更新请求
 * @Author zhaoyu
 * @Date 2024/11/4
 */
@Data
public class PostUpdateRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表
     */
    private List<String> tags;

    private static final long serialVersionUID = 1L;
}

 