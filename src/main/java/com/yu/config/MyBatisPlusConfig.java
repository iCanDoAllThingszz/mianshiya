package com.yu.config;/**
 * @Author:zhoayu
 * @Date:2024/11/3 22:24
 * @Description:com.yu.config
 * @version:1.0
 */

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyBatisPlusConfig
 * @Description // mybatis-plus 配置
 * @Author zhaoyu
 * @Date 2024/11/3
 */

@Configuration
@MapperScan("com.yu.mapper")
public class MyBatisPlusConfig {
    /**
     * 拦截器配置
     * */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // 分页插件
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return mybatisPlusInterceptor;
    }
}

 