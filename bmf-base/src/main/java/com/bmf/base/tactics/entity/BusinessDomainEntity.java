package com.bmf.base.tactics.entity;

import com.bmf.base.BaseModel;
import com.bmf.base.tactics.valueobject.BusinessDomainValueObject;
import lombok.Data;

import java.util.List;

@Data
public class BusinessDomainEntity extends BaseModel {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
    /**
     * 实体唯一ID名称
     */
    private String entityIdName;
    /**
     * 实体唯一ID类型
     * @see com.bmf.base.enums.AttrTypeEnum
     */
    private String entityIdType;
    /**
     * 实体描述
     */
    private String entityDesc;
    /**
     * 业务领域实体属性列表
     */
    private List<DomainEntityAttr> entityAttrList;
    /**
     * 值对象列表
     */
    private List<BusinessDomainValueObject> valueObjectList;

}
