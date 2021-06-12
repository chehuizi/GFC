package com.chz.bmf.common;

/**
 * 业务域服务枚举
 */
public enum BusinessServiceNameEnum {

    SUPPLY_CHAIN_MANAGEMENT("supply_chain_management", "SCM", "供应链管理"),
    ;

    /** 领域名称 **/
    private String domainName;
    /** 服务名称 **/
    private String serviceName;
    /** 服务描述 **/
    private String desc;

    BusinessServiceNameEnum(String domainName, String serviceName, String desc) {
        this.domainName = domainName;
        this.serviceName = serviceName;
        this.desc = desc;
    }

}
