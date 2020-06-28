//package com.chenlh.config;
//
//import com.aliyun.oss.OSS;
//import com.aliyun.oss.model.OSSObjectSummary;
//import com.aliyun.oss.model.ObjectListing;
//import com.chenlh.utils.AliyunOSSUtil;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @Author: CHENLIHUI
// * @Description:
// * @Date: Create in 10:55 2020/6/18
// */
//public class test {
//
//    @Test
//    public void test() {
//        OSS oss = AliyunOSSUtil.getInstance();
//        OSS oss1 = AliyunOSSUtil.getInstance();
//        System.out.println(oss);
//        System.out.println(oss1);
////        ObjectListing objectListing = oss.listObjects("alohomora");
////// objectListing.getObjectSummaries获取所有文件的描述信息。
////        for(OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
////            System.out.println(" - " + objectSummary.getKey() + "  " +
////                    "(size = " + objectSummary.getSize() + ")");
////        }
//    }
//}
