package com.yu.annotation;/**
 * @Author:zhoayu
 * @Date:2024/11/3 21:15
 * @Description:com.yu.annotation
 * @version:1.0
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName AuthCheck
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/11/3
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {
    /**
     * 角色名称
     * */
    String mustRole() default "";
}

 