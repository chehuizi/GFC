package com.bmf.base.DO;

import com.bmf.base.BaseDO;
import lombok.Data;

@Data
public class DomainRelEventDO extends BaseDO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 事件编码
     */
    private Integer eventCode;
}
