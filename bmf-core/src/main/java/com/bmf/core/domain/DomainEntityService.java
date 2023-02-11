package com.bmf.core.domain;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.entity.BusinessDomainEntity;

/**
 * 领域实体服务
 */
public interface DomainEntityService {

    /**
     * 查询领域实体
     * @param domainEntity
     * @return
     */
    BusinessDomainEntity queryDomainEntity(BusinessDomainEntity domainEntity);

}
