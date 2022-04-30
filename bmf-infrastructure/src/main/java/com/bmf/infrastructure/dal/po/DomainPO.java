package com.bmf.infrastructure.dal.po;

import lombok.Data;

@Data
public class DomainPO extends BasePO {

    /**
     * 域名称
     */
    private String domainName;
    /**
     * 域类型
     */
    private String domainType;
    /**
     * 域等级
     */
    private int domainLevel;

}
