package com.yu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yu.model.entity.Post;

import java.util.Date;
import java.util.List;

/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:07
 * @Description: 帖子-持久层操作
 * @version:1.0
 */
public interface PostMapper extends BaseMapper<Post> {

    /**
     * 查询帖子列表（包括已被删除的数据）
     */
    List<Post> listPostWithDelete(Date minUpdateTime);
}
