package com.bmf.base.tactics.valueobject;

import com.bmf.base.BaseModel;
import com.bmf.base.enums.AttrTypeEnum;
import lombok.Data;

/**
 * 值对象属性
 */
@Data
public class ValueObjectAttr extends BaseModel {

    /**
     * 值对象编码
     */
    private Integer voCode;
    /**
     * 属性名称
     */
    private String attrName;
    /**
     * 属性类型
     * @see AttrTypeEnum
     */
    private String attrType;
    /**
     * 属性描述
     */
    private String attrDesc;

}
