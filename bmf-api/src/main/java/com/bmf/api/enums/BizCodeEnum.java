package com.bmf.api.enums;

import lombok.Getter;

/**
 * 业务错误码
 */
@Getter
public enum BizCodeEnum {
    BUSINESS_NOT_EXIST(100001, "业务不存在"),
    ;

    private int code;
    private String desc;

    BizCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
