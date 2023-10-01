package com.bmf.design.infrastructure.dal.po;

import lombok.Data;

@Data
public class UserDomainPO extends BasePO {

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 领域编码
     */
    private Integer domainCode;
}
