package com.bmf.base.tactics.service;

import com.bmf.base.BaseModel;
import lombok.Data;

@Data
public class BusinessDomainService extends BaseModel {

    /**
     * 服务编码
     */
    private Integer serviceCode;
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 服务描述
     */
    private String serviceDesc;

}
