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
     * null校验
     * @param param
     */
    public static void checkNull(Object param) {
        if (Objects.isNull(param)) {
            throw new BizException(BizCodeEnum.PARAM_ERROR);
        }
    }

    /**
     * null校验，同时返回信息
     * @param param
     * @param message
     */
    public static void checkNull(Object param, String message) {
        if (Objects.isNull(param)) {
            throw new BizException(BizCodeEnum.PARAM_ERROR, message);
        }
    }

    /**
     * 空校验
     * @param param
     * @param message
     */
    public static void checkBlank(String param, String message) {
        if (StringUtils.isBlank(param)) {
            throw new BizException(BizCodeEnum.PARAM_ERROR, message);
        }
    }

    /**
     * TRUE校验
     * @param condition
     * @param message
     */
    public static void checkTrue(boolean condition, String message) {
        if (!condition) {
            throw new BizException(BizCodeEnum.PARAM_ERROR, message);
        }
    }
}
