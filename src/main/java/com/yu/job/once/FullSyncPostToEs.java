package com.yu.job.once;/**
 * @Author:zhoayu
 * @Date:2024/11/4 12:18
 * @Description:com.yu.job.once
 * @version:1.0
 */

import com.yu.esdao.PostEsDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;

/**
 * @ClassName FullSyncPostToEs
 * @Description // 全量同步帖子到 es
 * @Author zhaoyu
 * @Date 2024/11/4
 */

// todo 取消注释开启任务
//@Component
@Slf4j
@Order(1)
public class FullSyncPostToEs implements CommandLineRunner {

    /**
     * CommandLineRunner接口是Spring Boot提供的一个接口，用于在Spring Boot应用启动后执行特定的代码。实现该接口的类会在所有Spring Beans都初始化完成后执行其run方法。通常用于在应用启动时进行一些初始化操作。
     *
     * 自动执行：实现CommandLineRunner接口的类会在Spring Boot应用启动后自动执行run方法。可以在这个方法中执行任何需要在应用启动后立即执行的代码，比如加载初始数据、检查配置等。
     * 多个实现：如果有多个CommandLineRunner实现类，可以使用@Order注解或实现Ordered接口来指定执行顺序。
     * */

    @Autowired
    private PostService postService;

    @Autowired
    private PostEsDao postEsDao;

}

 