package com.bmf.base.tactics.entity;

import com.bmf.base.BaseDO;
import com.bmf.base.enums.AttrTypeEnum;
import lombok.Data;

/**
 * 领域实体属性
 */
@Data
public class DomainEntityAttr extends BaseDO {

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
