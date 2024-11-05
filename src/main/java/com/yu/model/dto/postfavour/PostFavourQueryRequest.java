package com.yu.model.dto.postfavour;/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:26
 * @Description:com.yu.model.dto.postfavour
 * @version:1.0
 */

import com.yu.common.PageRequest;
import com.yu.model.dto.post.PostQueryRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @ClassName PostFavourQueryRequest
 * @Description // 帖子收藏情况查询请求
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PostFavourQueryRequest extends PageRequest implements Serializable {

    /**
     * 帖子查询请求
     */
    private PostQueryRequest postQueryRequest;

    /**
     * 用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}

 