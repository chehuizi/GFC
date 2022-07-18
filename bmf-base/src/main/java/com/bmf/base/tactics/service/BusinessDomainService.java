package com.bmf.base.tactics.service;

import com.bmf.base.BaseDO;
import com.bmf.base.tactics.aggregate.BusinessDomainAggregate;
import com.bmf.base.tactics.entity.BusinessDomainEntity;
import lombok.Data;

@Data
public class BusinessDomainService extends BaseDO {

    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 服务描述
     */
    private String serviceDesc;
    /**
     * 服务类型
     * @see com.bmf.base.enums.BusinessDomainServiceTypeEnum
     */
    private String serviceType;
    /**
     * 服务关联实体
     */
    private BusinessDomainEntity entity;
    /**
     * 服务关联聚合根
     */
    private BusinessDomainAggregate aggregate;
}
