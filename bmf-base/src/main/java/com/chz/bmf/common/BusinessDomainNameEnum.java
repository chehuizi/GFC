package com.chz.bmf.common;

/**
 * 业务域名称枚举
 */
public enum BusinessDomainNameEnum {

    SUPPLY_CHAIN_MANAGEMENT("supply_chain_management", "SCM", "供应链管理"),
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
