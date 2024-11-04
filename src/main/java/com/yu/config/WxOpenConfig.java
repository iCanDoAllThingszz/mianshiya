package com.yu.config;/**
 * @Author:zhoayu
 * @Date:2024/11/3 22:27
 * @Description:com.yu.config
 * @version:1.0
 */

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WxOpenConfig
 * @Description // 微信开放平台配置
 * @Author zhaoyu
 * @Date 2024/11/3
 */

@Slf4j
@Configuration
@ConfigurationProperties(prefix = "wx.open")
@Data
public class WxOpenConfig {

    private String appId;

    private String appSecret;

    private WxMpService wxMpService;

    /**
     * 单例模式（不用 @Bean 是为了防止和公众号的 service 冲突）
     *
     * @return
     */
    public WxMpService getWxMpService() {
        if (wxMpService != null) {
            return wxMpService;
        }
        synchronized (this) {
            //第二次加锁判空: 加锁的原因是防止单例初始化时 `内存分配、初始化和引用赋值`三个步骤 的指令重排序
            if (wxMpService != null) {
                return wxMpService;
            }
            WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
            config.setAppId(appId);
            config.setSecret(appSecret);
            WxMpService service = new WxMpServiceImpl();
            service.setWxMpConfigStorage(config);
            wxMpService = service;
            return wxMpService;
        }
    }
}

 