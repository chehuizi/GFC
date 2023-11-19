package com.bmf.common.utils.exception;

import com.bmf.common.api.enums.BizCodeEnum;
import lombok.Data;

/**
 * 业务异常
 */
@Data
public class BizException extends RuntimeException {

    /**
     * 错误码
     */
    private int code;

    /**
     * 业务异常
     * @param bizCodeEnum
     * @param ex
     */
    public BizException(BizCodeEnum bizCodeEnum, Exception ex) {
        super(bizCodeEnum.getDesc(), ex);
        this.setCode(bizCodeEnum.getCode());
    }

    /**
     * 业务异常
     * @param bizCodeEnum
     */
    public BizException(BizCodeEnum bizCodeEnum) {
        super(bizCodeEnum.getDesc());
        this.setCode(bizCodeEnum.getCode());
    }

    public BizException(BizCodeEnum bizCodeEnum, String extInfo) {
        super(bizCodeEnum.getDesc() + "[" + extInfo + "]");
        this.setCode(bizCodeEnum.getCode());
    }
}
