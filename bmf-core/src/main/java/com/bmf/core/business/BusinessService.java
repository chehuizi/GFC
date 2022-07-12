package com.bmf.core.business;

import com.bmf.base.Business;
import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.base.strategy.BusinessDomainRelationship;

/**
 * 业务服务
 */
public interface BusinessService {

    /**
     * 添加业务
     * @param business
     * @return
     */
    boolean addBusiness(Business business);

    /**
     * 添加领域
     * @param businessRelDomainDO
     * @return
     */
    boolean addDomain(BusinessRelDomainDO businessRelDomainDO);

    /**
     * 添加领域关系
     * @param businessDomainRelationship
     * @return
     */
    boolean addDomainRelation(BusinessDomainRelationship businessDomainRelationship);
}
