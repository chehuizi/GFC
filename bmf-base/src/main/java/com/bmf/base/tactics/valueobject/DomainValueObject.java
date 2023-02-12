package com.bmf.base.tactics.valueobject;

import com.bmf.base.BaseModel;
import lombok.Data;

import java.util.List;

@Data
public class DomainValueObject extends BaseModel {

    /**
     * 值对象编码
     */
    private Integer voCode;
    /**
     * 值对象名称
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
