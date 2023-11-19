package com.bmf.design.model.tactics.valueobject;

import com.bmf.common.model.BaseModel;
import com.bmf.design.model.enums.AttrTypeEnum;
import lombok.Data;

/**
 * 值对象属性
 */
@Data
public class DomainValueObjectAttr extends BaseModel {

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
