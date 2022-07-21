package com.bmf.base.DO;

import com.bmf.base.BaseDO;
import lombok.Data;

@Data
public class EntityRelVODO extends BaseDO {

    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
    /**
     * 值对象编码
     */
    private Integer voCode;
}
