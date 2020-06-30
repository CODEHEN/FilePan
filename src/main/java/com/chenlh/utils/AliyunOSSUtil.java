package com.chenlh.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: CHENLIHUI
 * @Description:
 * @Date: Create in 10:32 2020/6/18
 */
public class AliyunOSSUtil {
    private String OSS_END_POINT = "xxxxx";

    private String OSS_ACCESS_KEY_ID = "xxxxxx";

    private String OSS_ACCESS_KEY_SECRET = "xxxxxx";

    private String OSS_BUCKET_NAME = "alohomora";

    @Bean
    @Scope("prototype")
    public OSS OssClient() {
        return new OSSClientBuilder().build(OSS_END_POINT,OSS_ACCESS_KEY_ID,OSS_ACCESS_KEY_SECRET);
    }



}
