package com.bmf.design.infrastructure.dal.po;

import lombok.Data;

@Data
public class DomainServicePO extends BasePO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 服务编码
     */
    private Integer serviceCode;
    /**
     * 服务别名（英文）
     */
    private String serviceAlias;
    /**
     * 服务名称（中文）
     */
    private String serviceName;
    /**
     * 服务描述
     */
    private String serviceDesc;

}
