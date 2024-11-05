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

    private volatile WxMpService wxMpService;

    /**
     * 单例模式（不用 @Bean 是为了防止和公众号的 service 冲突）
     *
     * DCL单例模式（Double Check Lock）中进行两次空值检查的原因主要有两个：
     *
     * 提高效率：第一次空值检查（if (instance == null)）是为了避免每次调用getInstance()方法时都进行同步，因为大部分时间instance对象已经被创建好了。如果instance已经存在，那么直接返回这个实例，而不需要进入同步块，这样可以减少不必要的同步操作，提高效率
     * 。
     * 确保线程安全：第二次空值检查是在同步块内部进行的（if (instance == null)）。这是为了防止多个线程同时进入同步块，并且都发现instance为null，从而创建多个实例。由于Java内存模型（JMM）的特性，可能会有多个线程同时通过第一个if判断，然后同时尝试创建实例。第二次检查确保了只有第一个进入同步块的线程会创建实例，其他线程在进入同步块后会发现实例已经被创建，因此不会再次创建
     *
     * 此外，使用volatile关键字修饰instance变量是为了解决指令重排序的问题。在没有volatile的情况下，instance = new Singleton()这个操作（分为内存分配、初始化和引用赋值三个步骤）可能会被重排序，导致其他线程看到一个尚未完全构造的实例，这会导致不可预知的错误。volatile保证了在写操作后，读操作能够看到最新的值，并且防止了指令重排序，确保了在多线程环境下instance的可见性和有序性
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

 