package com.yu.common;/**
 * @Author:zhoayu
 * @Date:2024/11/3 22:07
 * @Description:com.yu.common
 * @version:1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName DeleteRequest
 * @Description // 删除请求
 * @Author zhaoyu
 * @Date 2024/11/3
 */
@Data
public class DeleteRequest implements Serializable {

    private Long id;

    private static final long serialVersionUID = 1L;
}

 