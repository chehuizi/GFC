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
     * 领域名称
     */
    private String domainName;

    /**
     * 领域别名
     */
    private String domainAlias;

    /**
     * 领域类型
     * @see com.bmf.base.enums.BusinessDomainTypeEnum
     */
    private String domainType;

    /**
     * 领域等级
     * @see com.bmf.base.enums.BusinessDomainLevelEnum
     */
    private int domainLevel;

    public BusinessDomain(Integer domainCode, String domainName, String domainAlias, String domainType, int domainLevel) {
        this.domainCode = domainCode;
        this.domainName = domainName;
        this.domainAlias = domainAlias;
        this.domainType = domainType;
        this.domainLevel = domainLevel;
    }

    public BusinessDomain(int domainLevel, String domainType, String domainName, String domainAlias) {
        this.domainLevel = domainLevel;
        this.domainType = domainType;
        this.domainName = domainName;
        this.domainAlias = domainAlias;
    }

    public BusinessDomain() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"domainCode\": \"" + domainCode + "\"" +
                ", \"domainName\": \"" + domainName + "\"" +
                ", \"domainAlias\": \"" + domainAlias + "\"" +
                ", \"domainType\": \"" + domainType + "\"" +
                ", \"domainLevel\": " + domainLevel +
                "}";
    }
}
