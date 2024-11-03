package com.yu;/**
 * @Author:zhoayu
 * @Date:2024/11/3 21:04
 * @Description:com.yu
 * @version:1.0
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName MainApplication
 * @Description //TODO 
 * @Author zhaoyu
 * @Date 2024/11/3
 */

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@MapperScan("com.yu.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}

 