package com.bmf.api.exception;

import com.bmf.api.enums.BizCodeEnum;

/**
 * 业务异常
 */
public class BizException extends RuntimeException {

    /**
     * 业务异常
     * @param bizCodeEnum
     * @param ex
     */
    public BizException(BizCodeEnum bizCodeEnum, Exception ex) {
        super(bizCodeEnum.getDesc(), ex);
    }

    /**
     * 业务异常
     * @param bizCodeEnum
     */
    public BizException(BizCodeEnum bizCodeEnum) {
        super(bizCodeEnum.getDesc());
    }
}
