package com.bmf.design.model.tactics.valueobject;

import com.bmf.common.model.BaseModel;
import lombok.Data;

import java.util.List;

@Data
public class DomainValueObject extends BaseModel {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 值对象编码
     */
    private Integer voCode;
    /**
     * 值对象别名（英文）
     */
    private String voAlias;
    /**
     * 值对象名称（中文）
     */
    private String voName;
    /**
     * 值对象描述
     */
    private String  voDesc;
    /**
     * 值对象属性列表
     */
    private List<DomainValueObjectAttr> domainValueObjectAttrList;
}
