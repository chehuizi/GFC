package com.bmf.domain.base.enums;

/**
 * 业务域关系枚举
 */
public enum RelationshipEnum {

    PS("partnership", "合作伙伴"),
    SK("sharedKernel", "共享内核"),
    UD("upstream-downstream", "上下游"),
    CS("customer-supplier", "客户/供应商")
    ;

    /**
     * 关系类型
     */
    private String type;
    /**
     * 关系描述
     */
    private String desc;

    RelationshipEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

}
