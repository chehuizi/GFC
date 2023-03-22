package com.bmf.core.business;

import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.BusinessRelDomain;

import java.util.List;

/**
 * 业务服务
 */
public interface BusinessService {

    /**
     * 添加业务
     * @param business
     * @return
     */
    boolean createBusiness(Business business);

    /**
     * 查询业务
     * @param business
     * @return
     */
    Business queryBusiness(Business business);

    /**
     * 查询业务关联领域
     * @param business
     * @param domain
     * @return
     */
    BusinessRelDomain queryBusinessRelDomain(Business business, BusinessDomain domain);

    /**
     * 查询业务关联领域
     * @param business
     * @return
     */
    List<BusinessRelDomain> queryBusinessRelDomain(Business business);

    /**
     * 查询业务关联领域关系
     * @param business
     * @return
     */
    List<BusinessDomainRelation> queryBusinessDomainRelation(Business business);

    /**
     * 查询业务关联领域关系
     * @param business
     * @param domain
     * @return
     */
    List<BusinessDomainRelation> queryBusinessDomainRelation(Business business, BusinessDomain domain);

    /**
     * 添加领域
     * @param business
     * @param domain
     * @return
     */
    boolean addDomain(Business business, BusinessDomain domain);

    /**
     * 删除领域
     * @param business
     * @param domain
     * @return
     */
    boolean delDomain(Business business, BusinessDomain domain);
}
