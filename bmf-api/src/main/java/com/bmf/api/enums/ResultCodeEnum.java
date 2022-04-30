package com.bmf.api.enums;

import lombok.Getter;

/**
 * 结果码枚举
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    ;

    private int code;
    private String desc;

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
