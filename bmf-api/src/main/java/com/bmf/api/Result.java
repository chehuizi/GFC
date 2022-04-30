package com.bmf.api;

import com.bmf.api.enums.ResultCodeEnum;
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

    /**
     * 返回成功
     * @return
     */
    public static Result success(Object data) {
        Result result = new Result<>();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMsg(ResultCodeEnum.SUCCESS.getDesc());
        result.setData(data);
        return result;
    }
}
