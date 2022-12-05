package com.bmf.base.tactics;

import com.bmf.base.BaseDO;
import lombok.Data;

@Data
public class DomainRelEntity extends BaseDO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 实体唯一ID编码
     */
    private Integer entityIdCode;
}
