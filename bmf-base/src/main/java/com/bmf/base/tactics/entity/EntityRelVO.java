package com.bmf.base.tactics.entity;

import com.bmf.base.BaseModel;
import lombok.Data;

@Data
public class EntityRelVO extends BaseModel {

    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
    /**
     * 值对象编码
     */
    private Integer voCode;
}
