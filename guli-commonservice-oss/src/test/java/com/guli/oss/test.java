package com.guli.oss;

import com.aliyun.oss.OSSClient;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName test
 * @Description TODO
 * @Author User
 * @Date 2020/3/15 15:59
 * @Version 1.0
 * @Desc
 */
@SpringBootTest
public class test {

    String endpoint = "oss-cn-beijing.aliyuncs.com";
    String bucketName ="upload-file-clean-test";
    String accessKeyId="LTAI4FvtdjHuieC7qWs9gmv2";
    String accessKeySecret="jyb7W5FjWA9Eir2rbpMT2yRG14NOhH";

    @Test
    public void uploadTest(){
        //创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 创建存储空间。
        ossClient.createBucket(bucketName);
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
