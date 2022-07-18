package com.bmf.base.DO;

import com.bmf.base.BaseDO;
import lombok.Data;

@Data
public class DomainRelEntityDO extends BaseDO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
}
