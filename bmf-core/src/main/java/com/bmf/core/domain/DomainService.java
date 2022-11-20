package com.bmf.core.domain;

import com.bmf.base.BusinessDomain;
import com.bmf.base.tactics.entity.BusinessDomainEntity;

/**
 * 业务领域服务
 */
public interface DomainService {

    /**
     * 创建领域
     * @param businessDomain
     * @return
     */
    boolean createDomain(BusinessDomain businessDomain);

    /**
     * 查询领域
     * @param businessDomain
     * @return
     */
    BusinessDomain queryDomain(BusinessDomain businessDomain);

    /**
     * 删除领域
     * @param businessDomain
     * @return
     */
    boolean deleteDomain(BusinessDomain businessDomain);
}
