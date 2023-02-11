package com.bmf.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * code key枚举
 */
@Getter
@AllArgsConstructor
public enum CodeKeyEnum {
    CODE_KEY_BUSINESS("business", "业务"),
    CODE_KEY_DOMAIN("domain", "领域"),
    CODE_KEY_ENTITY("entity", "实体"),
    ;

    /**
     * key
     */
    private String key;
    /**
     * key描述
     */
    private String desc;

}
