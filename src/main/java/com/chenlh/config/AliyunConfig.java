package com.chenlh.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: CHENLIHUI
 * @Description:
 * @Date: Create in 9:32 2020/6/18
 */
@Configuration
@Component
@Getter
@Setter
public class AliyunConfig {

    @Value("${aliyun.oss.endpoint}")
    private String OSS_END_POINT;

    @Value("${aliyun.access.key.id}")
    private  String OSS_ACCESS_KEY_ID;

    @Value("${aliyun.access.key.secret}")
    private  String OSS_ACCESS_KEY_SECRET;

//    @Value("${lximage.filehost}")
//    private  String OSS_FILE_HOST;

    @Value("${aliyun.oss.bucket.name}")
    public String OSS_BUCKET_NAME;
}

