package com.bmf.design.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务前缀枚举
 */
@Getter
@AllArgsConstructor
public enum BusinessPrefixEnum {

    B("B", "默认前缀（business首字母）"),
    ;

    private String prefix;
    private String desc;

    /**
     * 是否包含
     * @param prefix
     * @return
     */
    public static boolean contain(String prefix) {
        for (BusinessPrefixEnum item : BusinessPrefixEnum.values()) {
            if (item.getPrefix().equals(prefix)) {
                return true;
            }
        }
        return false;
    }
}
