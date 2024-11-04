package com.yu.config;/**
 * @Author:zhoayu
 * @Date:2024/11/3 22:17
 * @Description:com.yu.config
 * @version:1.0
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName CorsConfig
 * @Description // 全局跨域配置
 * @Author zhaoyu
 * @Date 2024/11/3
 */

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 覆盖所有请求
        registry.addMapping("/**")
                // 允许携带cookie, http认证等
                .allowCredentials(true)
                // 允许所有域的请求
                .allowedOriginPatterns("*")
                // 指定允许的http方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 指定允许的http请求头
                .allowedHeaders("*")
                // 指定哪些响应头可以被前端JavaScript读取
                .exposedHeaders("*");
    }
}

 