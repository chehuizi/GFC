package com.bmf.common.api;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 结果码
     */
    private int code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 数据
     */
    private T data;

}
