package com.bmf.common.enums;

import lombok.Getter;

/**
 * 业务错误码
 */
@Getter
public enum BizCodeEnum {
    /******************** 系统错误码 start *********************/
    PARAM_ERROR(80001, "参数错误"),
    VALIDATOR_ERROR(90001, "校验器异常"),
    VALIDATOR_METHOD_NOT_FOUND(90002, "校验器方法不存在"),
    /******************** 系统错误码 end   *********************/

    /******************** api层错误码 start ********************/
    BUSINESS_NOT_EXIST(100001, "业务不存在"),
    DOMAIN_NOT_EXIST(100002, "领域不存在"),
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
