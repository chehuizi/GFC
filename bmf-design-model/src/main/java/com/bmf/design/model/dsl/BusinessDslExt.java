package com.bmf.design.model.dsl;

import com.bmf.common.model.BaseModel;
import com.bmf.design.model.enums.AttrTypeEnum;
import lombok.Data;

/**
 * DSL扩展类
 */
@Data
public class BusinessDslExt extends BaseModel {

    /**
     * 术语编码
     */
    private Integer dslCode;
    /**
     * 扩展类型
     * @see AttrTypeEnum
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
