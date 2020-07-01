package com.chenlh.service;

import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectListing;
import com.chenlh.vo.File;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Author: CHENLIHUI
 * @Description:
 * @Date: Create in 11:33 2020/6/18
 */
public interface FileService {
    List<Object> getIndexFile();

    List<Object> getDirFile(String dir);

    Map<String, InputStream> downLoadFile(String path);

    Boolean uploadFile(String pathAndName) throws FileNotFoundException;
}
