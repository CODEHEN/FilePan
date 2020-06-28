package com.chenlh.utils;

import java.io.UnsupportedEncodingException;

/**
 * @Author: CHENLIHUI
 * @Description:
 * @Date: Create in 21:08 2020/6/23
 */
public class EncodingTool {
    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
