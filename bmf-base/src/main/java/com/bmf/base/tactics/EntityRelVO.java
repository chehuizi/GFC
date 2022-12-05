package com.bmf.base.tactics;

import com.bmf.base.BaseDO;
import lombok.Data;

@Data
public class EntityRelVO extends BaseDO {

    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
    /**
     * 值对象编码
     */
    private Integer voCode;
}
