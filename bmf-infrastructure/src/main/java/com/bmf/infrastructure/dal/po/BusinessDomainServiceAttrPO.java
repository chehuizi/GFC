package com.bmf.infrastructure.dal.po;

import com.bmf.base.enums.AttrTypeEnum;
import lombok.Data;

@Data
public class BusinessDomainServiceAttrPO extends BasePO {

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
