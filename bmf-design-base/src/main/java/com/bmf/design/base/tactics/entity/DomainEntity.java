package com.bmf.design.base.tactics.entity;

import com.bmf.design.base.BaseModel;
import com.bmf.design.base.tactics.valueobject.DomainValueObject;
import com.bmf.design.base.enums.AttrTypeEnum;
import lombok.Data;

import java.util.List;

@Data
public class DomainEntity extends BaseModel {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
    /**
     * 实体唯一ID别名（英文）
     */
    private String entityIdAlias;
    /**
     * 实体唯一ID名称（中文）
     */
    private String entityIdName;
    /**
     * 实体唯一ID类型
     * @see AttrTypeEnum
     */
    private String entityIdType;
    /**
     * 实体描述
     */
    private String entityDesc;
    /**
     * 实体属性列表
     */
    private List<DomainEntityAttr> entityAttrList;
    /**
     * 值对象列表
     */
    private List<DomainValueObject> valueObjectList;

}
