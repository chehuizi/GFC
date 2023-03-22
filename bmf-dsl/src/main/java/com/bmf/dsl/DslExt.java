package com.bmf.dsl;

import lombok.Data;

/**
 * DSL扩展类
 */
@Data
public class DslExt {

    /**
     * 扩展类型
     * @see com.bmf.base.enums.AttrTypeEnum
     */
    private String extType;
    /**
     * 扩展key
     */
    private String extKey;
    /**
     * 扩展value
     */
    private Object extVal;
}
