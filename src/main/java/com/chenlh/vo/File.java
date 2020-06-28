package com.chenlh.vo;

import lombok.Data;

/**
 * @Author: CHENLIHUI
 * @Description:
 * @Date: Create in 11:13 2020/6/22
 */
@Data
public class File {
    private String key;
    private String type;
    private String prefix;
    private long size;
}
