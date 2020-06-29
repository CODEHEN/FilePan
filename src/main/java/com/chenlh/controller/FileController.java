package com.chenlh.controller;

import com.chenlh.service.FileService;
import com.chenlh.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @Author: CHENLIHUI
 * @Description:
 * @Date: Create in 15:25 2020/6/22
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/index")
    public Result<List<Object>> indexFile() {
        return Result.createBySuccess(10, fileService.getIndexFile());
    }

    @RequestMapping("/Dir")
    public Result<List<Object>> dirFile(String dir) {
        return Result.createBySuccess(10, fileService.getDirFile(dir));
    }

    @RequestMapping("/download")
    public Result<String> downLoadFile(String path, HttpServletResponse response) throws IOException {
        BufferedInputStream bis = null;
        OutputStream toClient = null;
        String fileName = null;

        Map<String, InputStream> map = fileService.downLoadFile(path);
        for (String name : map.keySet()) {
            fileName = name;
        }

        try {
            // 已缓冲的方式从字符输入流中读取文本，缓冲各个字符，从而提供字符、数组和行的高效读取

            bis = new BufferedInputStream(map.get(fileName));

            toClient = new BufferedOutputStream(response.getOutputStream());

            response.setContentType("application/octet-stream");

            //处理文件名为中文的情况
            response.setHeader("Content-Disposition","attach;filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));

            //*处理oss文件流传输*
            int number;
            byte[] buffer = new byte[512];
            while ((number = bis.read(buffer)) != -1){
                toClient.write(buffer,0,number);
            }
            toClient.flush();
            toClient.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(toClient != null){
                toClient.close();
            }
            if(bis != null){
                bis.close();
            }

        }
        return Result.createByNull("success");
    }
}
