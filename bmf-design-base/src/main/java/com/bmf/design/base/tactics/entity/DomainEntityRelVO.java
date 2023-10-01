package com.bmf.design.base.tactics.entity;

import com.bmf.design.base.BaseModel;
import lombok.Data;

@Data
public class DomainEntityRelVO extends BaseModel {

    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
    /**
     * 值对象编码
     */
    private Integer voCode;
}
