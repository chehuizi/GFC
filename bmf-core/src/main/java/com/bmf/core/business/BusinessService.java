package com.bmf.core.business;

import com.bmf.api.Result;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.base.strategy.BusinessDomainRelationship;

/**
 * 业务cmd服务
 */
public interface BusinessService {

    /**
     * 添加业务
     * @param business
     * @return
     */
    Result<Boolean> addBusiness(Business business);

    /**
     * 添加领域
     * @param businessRelDomainDO
     * @return
     */
    Result<Boolean> addDomain(BusinessRelDomainDO businessRelDomainDO);

    /**
     * 添加领域关系
     * @param businessDomainRelationship
     * @return
     */
    Result<Boolean> addDomainRelation(BusinessDomainRelationship businessDomainRelationship);
}
