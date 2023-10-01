package com.bmf.design.infrastructure.dal.po;

import com.bmf.design.base.enums.AttrTypeEnum;
import lombok.Data;

@Data
public class DomainServiceAttrPO extends BasePO {

    /**
     * 领域服务编码
     */
    private Integer serviceCode;
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
