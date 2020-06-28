package com.chenlh.utils;

import lombok.Data;

/**
 * @Author: CHENLIHUI
 * @Description:
 * @Date: Create in 15:02 2020/6/22
 */
@Data
public class Result<T> {
    private int code;
    private long count;
    private String msg;
    private T data;

    /**
     * @Description: 返回有数据的信息
     * @Param: [count, data]
     * @return: com.chenlh.utils.Result<T>
     */
    public static <T> Result<T> createBySuccess(long count, T data) {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), count, data);
    }

    /**
     * @Description: 空数据信息
     * @Param: [count, msg]
     * @return: com.chenlh.utils.Result<T>
     */
    public static <T> Result<T> createByNull(long count, String msg) {
        return new Result<T>(ResultEnum.NULL.getCode(), count, msg);
    }

    /**
     * @Description: 返回空数据信息(count为0)
     * @Param: [msg]
     * @return: com.chenlh.utils.Result<T>
     */
    public static <T> Result<T> createByNull(String msg) {
        return new Result<T>(ResultEnum.NULL.getCode(), ResultEnum.SUCCESS.getCode(), msg);
    }

    /**
     * @Description: 有数据的构造方法
     * @Param: [code, count, data]
     * @return:
     */
    public Result(int code, long count, T data) {
        this.code = code;
        this.count = count;
        this.data = data;
    }

    /*
     * @Description: 无数据的构造方法
     * @Param:
     * @return:
     */

    public Result(int code, long count, String msg) {
        this.code = code;
        this.count = count;
        this.msg = msg;
    }
}
