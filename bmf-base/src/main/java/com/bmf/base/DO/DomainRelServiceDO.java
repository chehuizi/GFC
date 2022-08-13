package com.bmf.base.DO;

import com.bmf.base.BaseDO;
import lombok.Data;

@Data
public class DomainRelServiceDO extends BaseDO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 服务编码
     */
    private Integer serviceCode;
}
