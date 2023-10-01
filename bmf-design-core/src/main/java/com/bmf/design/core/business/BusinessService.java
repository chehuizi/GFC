package com.bmf.design.core.business;

import com.bmf.design.base.Business;
import com.bmf.design.base.Domain;
import com.bmf.design.base.DomainRelation;
import com.bmf.design.base.BusinessRelDomain;
import com.bmf.design.base.enums.CmdTypeEnum;
import com.bmf.design.base.flow.BusinessRole;
import com.bmf.design.base.strategy.DomainRelationship;

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
    BusinessRelDomain queryBusinessRelDomain(Business business, Domain domain);

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
    List<DomainRelation> queryBusinessDomainRelation(Business business);

    /**
     * 查询业务关联领域关系
     * @param business
     * @param domain
     * @return
     */
    List<DomainRelation> queryBusinessDomainRelation(Business business, Domain domain);

    /**
     * 处理战略设计
     * @param business
     * @param domainResult
     * @param relationshipList
     * @return
     */
    boolean handleStrategyDesign(Business business,
                                 Map<CmdTypeEnum, List<Domain>> domainResult,
                                 List<DomainRelationship> relationshipList);

    /**
     * 添加领域
     * @param business
     * @param domain
     * @return
     */
    boolean addDomain(Business business, Domain domain);

    /**
     * 添加领域列表
     * @param business
     * @param domainList
     * @return
     */
    boolean addDomainList(Business business, List<Domain> domainList);

    /**
     * 删除领域
     * @param business
     * @param domain
     * @return
     */
    boolean delDomain(Business business, Domain domain);

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
