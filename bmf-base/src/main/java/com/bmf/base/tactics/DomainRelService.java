package com.bmf.base.tactics;

import com.bmf.base.BaseModel;
import lombok.Data;

@Data
public class DomainRelService extends BaseModel {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 服务编码
     */
    private Integer serviceCode;
}
