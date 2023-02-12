package com.bmf.core.domain;

import com.bmf.base.tactics.entity.DomainEntity;

/**
 * 领域实体服务
 */
public interface DomainEntityService {

    /**
     * 查询领域实体
     * @param domainEntity
     * @return
     */
    DomainEntity queryDomainEntity(DomainEntity domainEntity);

}
