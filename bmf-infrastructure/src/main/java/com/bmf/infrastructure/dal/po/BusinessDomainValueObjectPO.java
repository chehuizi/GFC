package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessDomainValueObjectPO extends BasePO {

    /**
     * 值对象编码
     */
    private Integer voCode;
    /**
     * 值对象名称
     */
    private String voName;
    /**
     * 值对象描述
     */
    private String  voDesc;
}
