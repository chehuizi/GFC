package com.bmf.base;

import lombok.Data;

@Data
public class BusinessRelDomain extends BaseDO {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 领域编码
     */
    private Integer domainCode;

}
