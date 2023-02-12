package com.bmf.core.domain;

import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;

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

    /**
     * 添加实体属性
     * @param entityAttr
     * @return
     */
    Boolean addEntityAttr(DomainEntityAttr entityAttr);
}
