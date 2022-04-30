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
     * @param t
     * @return
     */
    public Result<T> success(T t) {
        Result<T> result = new Result<>();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMsg(ResultCodeEnum.SUCCESS.getDesc());
        result.setData(t);
        return result;
    }
}
