package com.chz.bmf.domain.common;

/**
 * 业务域等级枚举
 * 目前只支持两级业务域
 */
public enum BusinessDomainLevelEnum {

    ONE(1, "一级业务域"),
    TWO(2, "二级业务域"),
    ;

    private int value;
    private String desc;

    BusinessDomainLevelEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

}
