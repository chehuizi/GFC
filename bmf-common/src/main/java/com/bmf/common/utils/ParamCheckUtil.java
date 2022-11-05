package com.bmf.common.utils;

import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.exception.BizException;

import java.util.Objects;

/**
 * 参数校验工具类
 */
public class ParamCheckUtil {

    /**
     * 校验参数是否是空
     * @param param
     */
    public static void checkNull(Object param) {
        if (Objects.isNull(param)) {
            throw new BizException(BizCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * 校验参数是否是空，同时返回信息
     * @param param
     * @param message
     */
    public static void checkNull(Object param, String message) {
        if (Objects.isNull(param)) {
            throw new BizException(BizCodeEnum.PARAM_ERROR, message);
        }
    }
}
