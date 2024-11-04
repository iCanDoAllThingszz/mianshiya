package com.yu.common;/**
 * @Author:zhoayu
 * @Date:2024/11/3 22:09
 * @Description:com.yu.common
 * @version:1.0
 */

import lombok.Data;

/**
 * @ClassName PageRequest
 * @Description // 分页请求
 * @Author zhaoyu
 * @Date 2024/11/3
 */
@Data
public class PageRequest {
    /**
     * 当前页号
     * */
    private int current = 1;

    /**
     * 页面大小
     * */
    private int pageSize = 10;

    /**
     * 排序字段
     * */
    private String sortField;

    /**
     * 排序顺序(默认升序)
     * */
    private String sortOrder = CommonConstant.SORT_ORDER_ASC;

}

 