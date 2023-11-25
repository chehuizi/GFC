package com.bmf.design.infrastructure.dal.po;

import lombok.Data;

@Data
public class DomainAppPO extends BasePO {

    /**
     * 应用ID
     */
    private Integer appId;
    /**
     * 应用名称
     */
    private String appName;
    /**
     * 应用描述
     */
    private String appDesc;
    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 领域别名（英文）
     */
    private String domainAlias;
}
