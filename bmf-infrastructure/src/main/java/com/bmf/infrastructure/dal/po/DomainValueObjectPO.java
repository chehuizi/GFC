package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class DomainValueObjectPO extends BasePO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 值对象编码
     */
    private Integer voCode;
    /**
     * 值对象别名（英文）
     */
    private String voAlias;
    /**
     * 值对象名称
     */
    private String voName;
    /**
     * 值对象描述
     */
    private String  voDesc;
}
