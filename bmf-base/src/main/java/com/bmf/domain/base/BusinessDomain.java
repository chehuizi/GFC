package com.bmf.domain.base;

import lombok.Data;

/**
 * 业务领域
 */
@Data
public class BusinessDomain {

    /**
     * 业务域等级
     * @see com.bmf.domain.base.enums.BusinessDomainLevelEnum
     */
    private int domainLevel;

    /**
     * 业务域类型
     */
    private String domainType;

}
