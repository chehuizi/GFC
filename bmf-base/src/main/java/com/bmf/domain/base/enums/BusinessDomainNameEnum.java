package com.bmf.domain.base.enums;

import lombok.Getter;

/**
 * 业务域名称枚举
 */
@Getter
public enum BusinessDomainNameEnum {

    SUPPLY_CHAIN_MANAGEMENT("supply_chain_management", "SCM", "供应链域"),
    INVENTORY_MANAGEMENT_SERVICE("inventory_management_service", "IMS", "仓储平台域"),
    ;

    /** 名称 **/
    private String name;
    /** 缩写 **/
    private String abbr;
    /** 描述 **/
    private String desc;

    BusinessDomainNameEnum(String name, String abbr, String desc) {
        this.name = name;
        this.abbr = abbr;
        this.desc = desc;
    }
}
