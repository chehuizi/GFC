package com.bmf.core.business;

import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.BusinessRelDomain;
import com.bmf.base.enums.CmdTypeEnum;
import com.bmf.base.flow.BusinessRole;
import com.bmf.base.strategy.BusinessDomainRelationship;

import java.util.List;
import java.util.Map;

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
     * 更新业务
     * @param business
     * @return
     */
    boolean updateBusiness(Business business);

    /**
     * 查询业务
     * @param business
     * @return
     */
    Business queryBusiness(Business business);

    /**
     * 查询业务列表
     * @param businessCodeList
     * @return
     */
    List<Business> queryBusinessList(List<Integer> businessCodeList);

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
     * 处理战略设计
     * @param business
     * @param domainResult
     * @param relationshipList
     * @return
     */
    boolean handleStrategyDesign(Business business,
                                 Map<CmdTypeEnum, List<BusinessDomain>> domainResult,
                                 List<BusinessDomainRelationship> relationshipList);

    /**
     * 添加领域
     * @param business
     * @param domain
     * @return
     */
    boolean addDomain(Business business, BusinessDomain domain);

    /**
     * 添加领域列表
     * @param business
     * @param domainList
     * @return
     */
    boolean addDomainList(Business business, List<BusinessDomain> domainList);

    /**
     * 删除领域
     * @param business
     * @param domain
     * @return
     */
    boolean delDomain(Business business, BusinessDomain domain);

    /**
     * 添加角色
     * @param business
     * @param role
     * @return
     */
    boolean addRole(Business business, BusinessRole role);

    /**
     * 删除角色
     * @param business
     * @param role
     * @return
     */
    boolean delRole(Business business, BusinessRole role);
}
