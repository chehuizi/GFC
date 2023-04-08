package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessDslExtPO extends BasePO {

    /**
     * DSL编码
     */
    private Integer dslCode;
    /**
     * DSL扩展类型
     */
    private String dslExtType;
    /**
     * 扩展key
     */
    private String dslExtKey;
    /**
     * 扩展value
     */
    private Object dslExtVal;

}
