package com.bmf.design.infrastructure.dal.po;

import lombok.Data;

@Data
public class DomainPO extends BasePO {

    /**
     * 领域编码
     */
    private Integer domainCode;
    /**
     * 域名称
     */
    private String domainName;
    /**
     * 领域别名
     */
    private String domainAlias;
    /**
     * 域类型
     */
    private String domainType;
    /**
     * 域等级
     */
    private int domainLevel;

}
