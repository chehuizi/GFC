package com.bmf.common.enums;

import lombok.Getter;

/**
 * 业务错误码
 */
@Getter
public enum BizCodeEnum {
    /******************** api层错误码 start ********************/
    BUSINESS_NOT_EXIST(100001, "业务不存在"),
    /******************** api层错误码 end   ********************/

    /******************** core层错误码 start ********************/

    /******************** core层错误码 end   ********************/
    ;

    private int code;
    private String desc;

    BizCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
