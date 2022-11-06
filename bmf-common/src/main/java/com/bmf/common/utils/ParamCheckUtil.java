package com.bmf.common.utils;

import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 参数校验工具类
 */
public class ParamCheckUtil {

    /**
     * 为空校验
     * @param param
     */
    public static void checkNull(Object param) {
        if (Objects.isNull(param)) {
            throw new BizException(BizCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * 为空校验，同时返回信息
     * @param param
     * @param message
     */
    public static void checkNull(Object param, String message) {
        if (Objects.isNull(param)) {
            throw new BizException(BizCodeEnum.PARAM_ERROR, message);
        }
    }

    public static void checkBlank(String param, String message) {
        if (StringUtils.isBlank(param)) {
            throw new BizException(BizCodeEnum.PARAM_ERROR, message);
        }
    }
}
