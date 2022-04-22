package com.bmf.domain.base.enums;

import lombok.Getter;

/**
 * 业务域等级枚举
 * 目前只支持三级业务域
 */
@Getter
public enum BusinessDomainLevelEnum {

    ONE(1, "一级业务域"),
    TWO(2, "二级业务域"),
    Three(3, "三级业务域")
    ;

    private int value;
    private String desc;

    BusinessDomainLevelEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

}
