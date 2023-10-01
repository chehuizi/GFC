package com.bmf.design.common.utils;

import com.bmf.design.common.enums.BizCodeEnum;
import com.bmf.design.common.exception.BizException;

import java.util.Objects;

/**
 * 业务校验工具类
 */
public class BusinessCheckUtil {

    /**
     * 为空校验
     * @param obj
     * @param bizCodeEnum
     */
    public static void checkNull(Object obj, BizCodeEnum bizCodeEnum) {
        if (Objects.isNull(obj)) {
            throw new BizException(bizCodeEnum);
        }
    }

    /**
     * 不为空校验
     * @param obj
     * @param bizCodeEnum
     */
    public static void checkNonNull(Object obj, BizCodeEnum bizCodeEnum) {
        if (Objects.nonNull(obj)) {
            throw new BizException(bizCodeEnum);
        }
    }

    /**
     * true校验
     * @param condition
     * @param bizCodeEnum
     */
    public static void checkTrue(boolean condition, BizCodeEnum bizCodeEnum) {
        if (!condition) {
            throw new BizException(bizCodeEnum);
        }
    }
}
