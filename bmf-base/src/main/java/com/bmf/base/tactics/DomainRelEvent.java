package com.bmf.base.tactics;

import com.bmf.base.BaseModel;
import lombok.Data;

@Data
public class DomainRelEvent extends BaseModel {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 事件编码
     */
    private Integer eventCode;
}
