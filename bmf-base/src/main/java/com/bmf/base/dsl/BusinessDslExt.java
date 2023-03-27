package com.bmf.base.dsl;

import lombok.Data;

/**
 * DSL扩展类
 */
@Data
public class BusinessDslExt {

    /**
     * 扩展类型
     * @see com.bmf.base.enums.AttrTypeEnum
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
