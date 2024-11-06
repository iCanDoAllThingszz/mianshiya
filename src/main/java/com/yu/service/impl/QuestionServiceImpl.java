package com.yu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.mapper.QuestionMapper;
import com.yu.service.QuestionService;
import org.springframework.stereotype.Service;
import com.yu.model.entity.Question;

/**
* @author zhaoyu
* @description 针对表【question(题目)】的数据库操作Service实现
* @createDate 2024-11-06 12:10:14
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>  implements QuestionService {

}




