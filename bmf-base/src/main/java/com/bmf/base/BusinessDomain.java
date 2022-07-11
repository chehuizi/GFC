package com.bmf.base;

import lombok.Data;

/**
 * 业务领域
 */
@Data
public class BusinessDomain extends BaseDO {

    /**
     * 领域编码
     */
    private Integer domainCode;

    /**
     * 业务域名称
     */
    private String domainName;

    /**
     * 业务域类型
     * @see com.bmf.base.enums.BusinessDomainTypeEnum
     */
    private String domainType;

    /**
     * 业务域等级
     * @see com.bmf.base.enums.BusinessDomainLevelEnum
     */
    private int domainLevel;

    public BusinessDomain(int domainLevel, String domainType, String domainName) {
        this.domainLevel = domainLevel;
        this.domainType = domainType;
        this.domainName = domainName;
    }

    public BusinessDomain() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"domainName\": \"" + domainName + "\"" +
                ", \"domainType\": \"" + domainType + "\"" +
                ", \"domainLevel\": " + domainLevel +
                "}";
    }
}
