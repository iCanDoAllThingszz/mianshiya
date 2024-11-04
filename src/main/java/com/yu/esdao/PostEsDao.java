package com.yu.esdao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author:zhoayu
 * @Date:2024/11/4 12:02
 * @Description: 帖子的ES操作
 * @version:1.0
 */
public interface PostEsDao extends ElasticsearchRepository<PostEsDTO, Long> {

    List<PostEsDTO> findByUserId(Long userId);
}
