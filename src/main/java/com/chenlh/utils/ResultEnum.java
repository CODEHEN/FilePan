package com.chenlh.utils;

/**
 * @Author: CHENLIHUI
 * @Description:
 * @Date: Create in 14:57 2020/6/22
 */
public enum ResultEnum {
    /**
     * @Description: 枚举类型，0成功，1失败
     * @Param: 
     * @return: 
     */
    SUCCESS(0),
    NULL(1);

    private int code;

    private ResultEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
