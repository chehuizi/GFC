package com.bmf.core.domain;

import com.bmf.base.BusinessDomain;

/**
 * 业务领域服务
 */
public interface DomainService {

    /**
     * 创建
     * @param businessDomain
     * @return
     */
    boolean create(BusinessDomain businessDomain);
}
