package com.bmf.core.business.impl;

import com.bmf.base.DomainRelation;
import com.bmf.base.enums.CmdTypeEnum;
import com.bmf.base.flow.BusinessRole;
import com.bmf.base.Business;
import com.bmf.base.Domain;
import com.bmf.base.BusinessRelDomain;
import com.bmf.base.strategy.DomainRelationship;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.core.utils.BusinessUtil;
import com.bmf.core.business.BusinessService;
import com.bmf.infrastructure.dal.DomainRelationRepository;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.BusinessRepository;
import com.bmf.infrastructure.dal.BusinessRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private BusinessRelDomainRepository businessRelDomainRepository;
    @Autowired
    private DomainRelationRepository domainRelationRepository;
    @Autowired
    private BusinessRoleRepository businessRoleRepository;

    @Override
    public boolean createBusiness(Business business) {
        return businessRepository.insert(business);
    }

    @Override
    public boolean updateBusiness(Business business) {
        return businessRepository.update(business);
    }

    @Override
    public Business queryBusiness(Business business) {
        return businessRepository.selectOne(business);
    }

    @Override
    public List<Business> queryBusinessList(List<Integer> businessCodeList) {
        return businessRepository.selectByBusinessCode(businessCodeList);
    }

    @Override
    public List<BusinessRelDomain> queryBusinessRelDomain(Business business) {
        return businessRelDomainRepository.selectByBusinessCode(business.getBusinessCode());
    }

    @Override
    public BusinessRelDomain queryBusinessRelDomain(Business business, Domain domain) {
        BusinessRelDomain businessRelDomain = BusinessUtil.convert(business, domain);
        return businessRelDomainRepository.selectOne(businessRelDomain);
    }

    @Override
    public List<DomainRelation> queryBusinessDomainRelation(Business business) {
        return domainRelationRepository.selectByBusinessCode(business.getBusinessCode());
    }

    @Override
    public List<DomainRelation> queryBusinessDomainRelation(Business business, Domain domain) {
        DomainRelation domainRelation = BusinessUtil.convertDR(business, domain);
        return domainRelationRepository.selectByDomain(domainRelation);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean handleStrategyDesign(Business business,
                                        Map<CmdTypeEnum, List<Domain>> domainResult,
                                        List<DomainRelationship> relationshipList) {
        boolean result;

        result = businessRelDomainRepository.deleteByBusinessCode(business.getBusinessCode());
        BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_BUSINESS_REL_DOMAIN_DELETED_FAILED);

        List<BusinessRelDomain> insertedBusinessRelDomainList = convert(business, domainResult, CmdTypeEnum.INSERT);
        if (Objects.nonNull(insertedBusinessRelDomainList) && !insertedBusinessRelDomainList.isEmpty()) {
            result = businessRelDomainRepository.batchInsert(insertedBusinessRelDomainList);
            BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_BUSINESS_REL_DOMAIN_INSERTED_FAILED);
        }

        List<BusinessRelDomain> updatedBusinessRelDomainList = convert(business, domainResult, CmdTypeEnum.UPDATE);
        if (Objects.nonNull(updatedBusinessRelDomainList) && !updatedBusinessRelDomainList.isEmpty()) {
            result = businessRelDomainRepository.batchInsert(updatedBusinessRelDomainList);
            BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_BUSINESS_REL_DOMAIN_INSERTED_FAILED);
        }

        result = domainRelationRepository.deleteByBusinessCode(business.getBusinessCode());
        BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_DOMAIN_RELATION_DELETED_FAILED);

        result = domainRelationRepository.batchInsert(BusinessUtil.convert(business, relationshipList));
        BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_DOMAIN_RELATION_INSERTED_FAILED);

        return true;
    }

    /**
     * 转换对象
     * @param business
     * @param domainResult
     * @param cmdTypeEnum
     * @return
     */
    private List<BusinessRelDomain> convert(Business business,
                                            Map<CmdTypeEnum, List<Domain>> domainResult,
                                            CmdTypeEnum cmdTypeEnum) {
        List<Domain> domainList = domainResult.get(cmdTypeEnum);
        if (Objects.isNull(domainList) || domainList.isEmpty()) {
            return null;
        }

        List<BusinessRelDomain> businessRelDomainList = new ArrayList<>();
        for (Domain domain : domainList) {
            BusinessRelDomain businessRelDomain = new BusinessRelDomain();
            businessRelDomain.setBusinessCode(business.getBusinessCode());
            businessRelDomain.setDomainCode(domain.getDomainCode());
            businessRelDomain.setDomainPosition(domain.getDomainPosition());
            businessRelDomainList.add(businessRelDomain);
        }

        return businessRelDomainList;
    }

    @Override
    public boolean addDomain(Business business, Domain domain) {
        BusinessRelDomain businessRelDomain = new BusinessRelDomain();
        businessRelDomain.setBusinessCode(business.getBusinessCode());
        businessRelDomain.setDomainCode(domain.getDomainCode());
        businessRelDomain.setDomainPosition(domain.getDomainPosition());
        return businessRelDomainRepository.insert(businessRelDomain);
    }

    @Override
    public boolean addDomainList(Business business, List<Domain> domainList) {
        List<BusinessRelDomain> businessRelDomainList = buildBusinessRelDomain(business, domainList);
        return businessRelDomainRepository.batchInsert(businessRelDomainList);
    }

    /**
     * 构建业务和领域关系
     * @param business
     * @param domainList
     * @return
     */
    private List<BusinessRelDomain> buildBusinessRelDomain(Business business,
                                                           List<Domain> domainList) {
        List<BusinessRelDomain> businessRelDomainList = new ArrayList<>();
        for (Domain domain : domainList) {
            BusinessRelDomain businessRelDomain = new BusinessRelDomain();
            businessRelDomain.setBusinessCode(business.getBusinessCode());
            businessRelDomain.setDomainCode(domain.getDomainCode());
            businessRelDomain.setDomainPosition(domain.getDomainPosition());
            businessRelDomainList.add(businessRelDomain);
        }
        return businessRelDomainList;
    }

    @Override
    public boolean delDomain(Business business, Domain domain) {
        BusinessRelDomain businessRelDomain = new BusinessRelDomain();
        businessRelDomain.setBusinessCode(business.getBusinessCode());
        businessRelDomain.setDomainCode(domain.getDomainCode());
        return businessRelDomainRepository.delete(businessRelDomain);
    }

    @Override
    public boolean addRole(Business business, BusinessRole role) {
        return businessRoleRepository.insert(role);
    }

    @Override
    public boolean delRole(Business business, BusinessRole role) {
        return businessRoleRepository.delete(role);
    }
}
