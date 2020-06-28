package com.chenlh.utils;

import com.aliyun.oss.model.OSSObjectSummary;

import java.util.List;

/**
 * @Author: CHENLIHUI
 * @Description: 删除文件夹和文件前缀
 * @Date: Create in 15:23 2020/6/26
 */
public class DeletePrefix {

    public List<OSSObjectSummary> deletePrefix(List<OSSObjectSummary> ossObjectSummaryList, String dir) {

        for (int i = 0; i < ossObjectSummaryList.size(); i++) {
            ossObjectSummaryList.get(i).setKey(ossObjectSummaryList.get(i).getKey().replaceAll(dir,""));
        }

        if ("".equals(ossObjectSummaryList.get(0).getKey())) {
            ossObjectSummaryList.remove(0);
        }

        return ossObjectSummaryList;
    }

}
