package com.bmf.common.utils;

import com.bmf.api.Result;
import com.bmf.common.enums.ResultCodeEnum;

public class ResultUtil {
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
