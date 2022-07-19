package com.bmf.base.tactics.valueobject;

import com.bmf.base.BaseDO;
import lombok.Data;

import java.util.List;

@Data
public class BusinessDomainValueObject extends BaseDO {

    /**
     * 值对象编码
     */
    private Integer voCode;
    /**
     * 值对象描述
     */
    private String  voDesc;
    /**
     * 值对象属性列表
     */
    private List<ValueObjectAttr> valueObjectAttrList;
}
