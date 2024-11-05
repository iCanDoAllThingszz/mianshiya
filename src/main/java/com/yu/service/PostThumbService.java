package com.yu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yu.model.entity.PostThumb;
import com.yu.model.entity.User;

/**
 * @Author:zhoayu
 * @Date:2024/11/4 20:24
 * @Description: 帖子点赞服务
 * @version:1.0
 */
public interface PostThumbService extends IService<PostThumb> {

    /**
     * 点赞
     *
     * @param postId
     * @param loginUser
     * @return
     */
    int doPostThumb(long postId, User loginUser);

    /**
     * 帖子点赞（内部服务）
     *
     * @param userId
     * @param postId
     * @return
     */
    int doPostThumbInner(long userId, long postId);
}
