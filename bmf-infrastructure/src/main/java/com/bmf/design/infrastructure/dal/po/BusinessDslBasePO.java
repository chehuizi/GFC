package com.bmf.design.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessDslBasePO extends BasePO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * DSL编码
     */
    private Integer dslCode;
    /**
     * DSL别名（英文）
     */
    private String dslAlias;
    /**
     * DSL名称（中文）
     */
    private String dslName;
    /**
     * DSL描述
     */
    private String dslDesc;

}
