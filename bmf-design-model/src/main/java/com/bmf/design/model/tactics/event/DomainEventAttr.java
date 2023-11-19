package com.bmf.design.model.tactics.event;

import com.bmf.common.model.BaseModel;
import com.bmf.design.model.enums.AttrTypeEnum;
import lombok.Data;

/**
 * 领域事件属性
 */
@Data
public class DomainEventAttr extends BaseModel {

    /**
     * 领域事件编码
     */
    private Integer eventCode;
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
