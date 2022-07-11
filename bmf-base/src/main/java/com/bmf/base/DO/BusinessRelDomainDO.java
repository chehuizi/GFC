package com.bmf.base.DO;

import com.bmf.base.BaseDO;
import lombok.Data;

@Data
public class BusinessRelDomainDO extends BaseDO {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 领域编码
     */
    private Integer domainCode;

}
