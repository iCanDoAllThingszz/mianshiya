package com.yu.utils;/**
 * @Author:zhoayu
 * @Date:2024/11/4 20:43
 * @Description:com.yu.utils
 * @version:1.0
 */

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName SqlUtils
 * @Description // SQL工具类
 * @Author zhaoyu
 * @Date 2024/11/4
 */
public class SqlUtils {

    /**
     * 校验排序字段是否合法（防止 SQL 注入）
     *
     * @param sortField
     * @return
     */
    public static boolean validSortField(String sortField) {
        if (StringUtils.isBlank(sortField)) {
            return false;
        }
        return !StringUtils.containsAny(sortField, "=", "(", ")", " ");
    }
}

 