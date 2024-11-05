package com.yu.model.entity;/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:37
 * @Description:com.yu.model.entity
 * @version:1.0
 */

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Post
 * @Description // 帖子-PO 持久层对象
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@TableName(value = "post")
@Data
public class Post implements Serializable {

    /**
     * id
     * */
    @TableId(type = IdType.ASSIGN_ID)
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
     * 标签列表 json
     */
    private String tags;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

 