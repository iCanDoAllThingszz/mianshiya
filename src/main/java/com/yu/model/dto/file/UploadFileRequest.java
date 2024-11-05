package com.yu.model.dto.file;/**
 * @Author:zhoayu
 * @Date:2024/11/4 19:12
 * @Description:com.yu.model.dto.file
 * @version:1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName UploadFileRequest
 * @Description // 文件上传请求
 * @Author zhaoyu
 * @Date 2024/11/4
 */

@Data
public class UploadFileRequest implements Serializable {

    private String biz;

    private static final long serialVersionUID = 1L;

}

 