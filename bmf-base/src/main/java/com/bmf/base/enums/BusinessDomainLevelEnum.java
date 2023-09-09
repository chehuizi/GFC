package com.bmf.base.enums;

import lombok.Getter;

/**
 * 业务域等级枚举
 * 目前只支持三级业务域
 */
@Getter
public enum BusinessDomainLevelEnum {

    ONE(1, "一级域"),
    TWO(2, "二级域"),
    THREE(3, "三级域")
    ;

    private int value;
    private String desc;

    BusinessDomainLevelEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    /**
     * 是否包含
     * @param level
     * @return
     */
    public static boolean contain(int level) {
        for (BusinessDomainLevelEnum item : BusinessDomainLevelEnum.values()) {
            if (item.getValue() == level) {
                return true;
            }
        }
        return false;
    }
}
