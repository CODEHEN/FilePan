package com.chenlh.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.chenlh.service.FileService;
import com.chenlh.utils.AliyunOSSUtil;
import com.chenlh.utils.DeletePrefix;
import com.chenlh.vo.File;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.*;

/**
 * @Author: CHENLIHUI
 * @Description:
 * @Date: Create in 11:14 2020/6/22
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {

    private static final String BUCKET_NAME = "alohomora";

    private final ListObjectsRequest listObjectsRequest = new ListObjectsRequest(BUCKET_NAME);

    /**
     * @Description: 获取根目录下的文件和文件夹
     * @Param: []
     * @return: java.util.List<java.lang.Object>
     */
    @Override
    public List<Object> getIndexFile() {

        OSS oss = new AliyunOSSUtil().OssClient();

        // 设置文件夹的分割符
        listObjectsRequest.setDelimiter("/");

        //指定目录，为null时则为根目录
        listObjectsRequest.setPrefix(null);

        ObjectListing listing = oss.listObjects(listObjectsRequest);

        List<Object> file = new ArrayList<>(listing.getObjectSummaries());

        for (String commonPrefix : listing.getCommonPrefixes()) {
            File file1 = new File();
            file1.setType("dir");
            file1.setPrefix(commonPrefix);
            file1.setKey(commonPrefix);
            file.add(file1);
        }
        oss.shutdown();
        return file;
    }

    /**
     * @Description: 获取指定目录的文件和文件夹
     * @Param: [dir]
     * @return: java.util.List<java.lang.Object>
     */
    @Override
    public List<Object> getDirFile(String dir) {
        OSS oss = new AliyunOSSUtil().OssClient();

        // 设置文件夹的分割符
        listObjectsRequest.setDelimiter("/");

        // 指定目录
        listObjectsRequest.setPrefix(dir);
        ObjectListing listing = oss.listObjects(listObjectsRequest);

        // 删除文件的前缀
        List<OSSObjectSummary> objectSummaries = new DeletePrefix().deletePrefix(listing.getObjectSummaries(),dir);

        List<Object> file = new ArrayList<>(objectSummaries);

        for (String commonPrefix : listing.getCommonPrefixes()) {
            File file1 = new File();

            file1.setType("dir");
            // 设置前缀，点击文件夹进入下一级文件夹时会用到
            file1.setPrefix(commonPrefix);

            //删除文件夹名的前缀
            file1.setKey(commonPrefix.replaceAll(dir,""));

            file.add(file1);
        }
        oss.shutdown();
        return file;
    }

    /**
     * @Description: 流式下载文件
     * @Param: [path]
     * @return: java.io.InputStream
     */
    @Override
    public Map<String,InputStream> downLoadFile(String path) {

        OSS oss = new AliyunOSSUtil().OssClient();

        OSSObject ossObject = oss.getObject(BUCKET_NAME, path);

        oss.getObject(BUCKET_NAME, path).getKey();

        HashMap<String,InputStream> map = new HashMap<>();

        map.put(ossObject.getKey(),ossObject.getObjectContent());

        return map;
    }


}
