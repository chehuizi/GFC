package com.chz.bmf.domain.base.meta;

/**
 * 上下文映射枚举
 */
public enum BusinessDomainContextMapperEnum {

    PARTNERSHIP("Partnership", "PS", "合作关系"),
    SHARED_KERNEL("Shared Kernel", "SK", "共享内核"),
    CUSTOMER_SUPPLIER_DEVELOPMENT("Customer-Supplier Development", "C-S", "客户方-供应方开发"),
    CONFORMIST("Conformist", "CONF", "遵奉者"),
    ANTICORRUPTION_LAYER("Anticorruption Layer", "ACL", "防腐层"),
    OPEN_HOST_SERVICE("Open Host Service", "OHS", "开放主机服务"),
    PUBLISHED_LANGUAGE("Published Language", "PL", "发布语言"),
    ;

    /**
     * 名称
     */
    private String name;
    /**
     * 缩写
     */
    private String abbr;
    /**
     * 描述
     */
    private String desc;

    BusinessDomainContextMapperEnum(String name, String abbr, String desc) {
        this.name = name;
        this.abbr = abbr;
        this.desc = desc;
    }
}
