package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class BusinessDomainServicePO extends BasePO {

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
