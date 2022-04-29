package com.bmf.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T extends BaseDTO> implements Serializable {

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
