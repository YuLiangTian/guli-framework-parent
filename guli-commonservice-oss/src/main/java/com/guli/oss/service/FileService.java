package com.guli.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileService
 * @Description TODO
 * @Author User
 * @Date 2020/3/15 16:51
 * @Version 1.0
 * @Desc
 */

public interface FileService {

    /**
     * 文件上传至阿里云
     * @param file
     * @return
     */
    String upload(MultipartFile file);

}
