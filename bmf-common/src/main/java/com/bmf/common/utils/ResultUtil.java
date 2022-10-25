package com.bmf.common.utils;

import com.bmf.api.Result;
import com.bmf.common.enums.ResultCodeEnum;

public class ResultUtil {
    /**
     * 成功
     * @return
     */
    public static Result success(Object data) {
        Result result = new Result<>();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setMsg(ResultCodeEnum.SUCCESS.getDesc());
        result.setData(data);
        return result;
    }

    /**
     * 失败
     * @param data
     * @return
     */
    public static Result fail(Object data) {
        Result result = new Result<>();
        result.setCode(ResultCodeEnum.FAIL_SYSTEM_ERROR.getCode());
        result.setMsg(ResultCodeEnum.FAIL_SYSTEM_ERROR.getDesc());
        result.setData(data);
        return result;
    }

    /**
     * 失败
     * @param code
     * @param message
     * @return
     */
    public static Result fail(int code, String message) {
        Result result = new Result<>();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }

    /**
     * 失败
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static Result fail(int code, String message, Object data) {
        Result result = new Result<>();
        result.setCode(code);
        result.setMsg(message);
        result.setData(data);
        return result;
    }
}
