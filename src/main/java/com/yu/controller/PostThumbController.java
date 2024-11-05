package com.yu.controller;/**
 * @Author:zhoayu
 * @Date:2024/11/4 11:56
 * @Description:com.yu.controller
 * @version:1.0
 */

import com.yu.common.BaseResponse;
import com.yu.common.ErrorCode;
import com.yu.common.ResultUtils;
import com.yu.exception.BusinessException;
import com.yu.model.dto.postthumb.PostThumbAddRequest;
import com.yu.model.entity.User;
import com.yu.service.PostThumbService;
import com.yu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName PostThumbController
 * @Description // 帖子点赞接口
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@RestController
@RequestMapping("/postThumb")
public class PostThumbController {

    @Autowired
    private PostThumbService postThumbService;

    @Autowired
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param postThumbAddRequest
     * @param request
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/doThumb")
    public BaseResponse<Integer> doThumb(@RequestBody PostThumbAddRequest postThumbAddRequest,
                                         HttpServletRequest request) {
        if (postThumbAddRequest == null || postThumbAddRequest.getPostId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser(request);
        long postId = postThumbAddRequest.getPostId();
        int result = postThumbService.doPostThumb(postId, loginUser);
        return ResultUtils.success(result);
    }
}

 