package com.yu.job.cycle;/**
 * @Author:zhoayu
 * @Date:2024/11/4 12:14
 * @Description:com.yu.job.cycle
 * @version:1.0
 */

import cn.hutool.core.collection.CollUtil;
import com.yu.esdao.PostEsDao;
import com.yu.mapper.PostMapper;
import com.yu.model.dto.post.PostEsDTO;
import com.yu.model.entity.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName IncSyncPostToEs
 * @Description // 增量同步帖子到 es, 定时任务
 * @Author zhaoyu
 * @Date 2024/11/4
 */

// todo 取消注释开启任务
//@Component
@Slf4j
public class IncSyncPostToEs {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostEsDao postEsDao;

    /**
     * 每分钟执行一次
     *
     * @Scheduled注解用于在Spring Boot中创建定时任务。它可以让方法按照指定的时间间隔或特定的时间点自动执行。
     */
    @Scheduled(fixedRate = 60 * 1000)
    public void run() {
        // 查询近 5 分钟内的数据
        Date fiveMinutesAgoDate = new Date(new Date().getTime() - 5 * 60 * 1000L);
        List<Post> postList = postMapper.listPostWithDelete(fiveMinutesAgoDate);
        if (CollUtil.isEmpty(postList)) {
            log.info("no inc post");
            return;
        }
        List<PostEsDTO> postEsDTOList = postList.stream()
                .map(PostEsDTO::objToDto)
                .collect(Collectors.toList());
        final int pageSize = 500;
        int total = postEsDTOList.size();
        log.info("IncSyncPostToEs start, total {}", total);
        for (int i = 0; i < total; i += pageSize) {
            int end = Math.min(i + pageSize, total);
            log.info("sync from {} to {}", i, end);
            postEsDao.saveAll(postEsDTOList.subList(i, end));
        }
        log.info("IncSyncPostToEs end, total {}", total);
    }
}

 