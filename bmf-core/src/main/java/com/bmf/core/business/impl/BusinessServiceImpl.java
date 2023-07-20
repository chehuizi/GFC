package com.bmf.core.business.impl;

import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.enums.CmdTypeEnum;
import com.bmf.base.flow.BusinessRole;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.BusinessRelDomain;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.utils.BusinessCheckUtil;
import com.bmf.core.utils.BusinessUtil;
import com.bmf.core.business.BusinessService;
import com.bmf.infrastructure.dal.BusinessDomainRelationRepository;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.BusinessRepository;
import com.bmf.infrastructure.dal.BusinessRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private BusinessRelDomainRepository businessRelDomainRepository;
    @Autowired
    private BusinessDomainRelationRepository businessDomainRelationRepository;
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
        BusinessRelDomain businessRelDomain = BusinessUtil.convert(business);
        return businessRelDomainRepository.selectList(businessRelDomain);
    }

    @Override
    public BusinessRelDomain queryBusinessRelDomain(Business business, BusinessDomain domain) {
        BusinessRelDomain businessRelDomain = BusinessUtil.convert(business, domain);
        return businessRelDomainRepository.selectOne(businessRelDomain);
    }

    @Override
    public List<BusinessDomainRelation> queryBusinessDomainRelation(Business business) {
        BusinessDomainRelation businessDomainRelation = BusinessUtil.convertDR(business);
        return businessDomainRelationRepository.selectList(businessDomainRelation);
    }

    @Override
    public List<BusinessDomainRelation> queryBusinessDomainRelation(Business business, BusinessDomain domain) {
        BusinessDomainRelation businessDomainRelation = BusinessUtil.convertDR(business, domain);
        return businessDomainRelationRepository.selectByDomain(businessDomainRelation);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean handleStrategyDesign(Business business,
                                        Map<CmdTypeEnum, List<BusinessDomain>> domainResult,
                                        List<BusinessDomainRelationship> relationshipList) {
        boolean result = businessRelDomainRepository.batchInsert(convert(business, domainResult,
                CmdTypeEnum.INSERT));
        BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_BUSINESS_REL_DOMAIN_INSERTED_FAILED);

        result = businessRelDomainRepository.batchUpdate(convert(business, domainResult,
                CmdTypeEnum.UPDATE));
        BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_BUSINESS_REL_DOMAIN_UPDATED_FAILED);

        result = businessRelDomainRepository.batchDelete(convert(business, domainResult,
                CmdTypeEnum.DELETE));
        BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_BUSINESS_REL_DOMAIN_DELETED_FAILED);

        result = businessDomainRelationRepository.deleteByBusinessCode(business.getBusinessCode());
        BusinessCheckUtil.checkTrue(result, BizCodeEnum.STRATEGY_DESIGN_DOMAIN_RELATION_DELETED_FAILED);

        result = businessDomainRelationRepository.batchInsert(BusinessUtil.convert(business, relationshipList));
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
                                            Map<CmdTypeEnum, List<BusinessDomain>> domainResult,
                                            CmdTypeEnum cmdTypeEnum) {
        List<BusinessDomain> domainList = domainResult.get(cmdTypeEnum);
        if (Objects.isNull(domainList) || domainList.isEmpty()) {
            return null;
        }

        List<BusinessRelDomain> businessRelDomainList = new ArrayList<>();
        for (BusinessDomain domain : domainList) {
            BusinessRelDomain businessRelDomain = new BusinessRelDomain();
            businessRelDomain.setBusinessCode(business.getBusinessCode());
            businessRelDomain.setDomainCode(domain.getDomainCode());
            businessRelDomain.setDomainPosition(domain.getDomainPosition());
            businessRelDomainList.add(businessRelDomain);
        }

        return businessRelDomainList;
    }

    @Override
    public boolean addDomain(Business business, BusinessDomain domain) {
        BusinessRelDomain businessRelDomain = new BusinessRelDomain();
        businessRelDomain.setBusinessCode(business.getBusinessCode());
        businessRelDomain.setDomainCode(domain.getDomainCode());
        businessRelDomain.setDomainPosition(domain.getDomainPosition());
        return businessRelDomainRepository.insert(businessRelDomain);
    }

    @Override
    public boolean addDomainList(Business business, List<BusinessDomain> domainList) {
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
                                                           List<BusinessDomain> domainList) {
        List<BusinessRelDomain> businessRelDomainList = new ArrayList<>();
        for (BusinessDomain domain : domainList) {
            BusinessRelDomain businessRelDomain = new BusinessRelDomain();
            businessRelDomain.setBusinessCode(business.getBusinessCode());
            businessRelDomain.setDomainCode(domain.getDomainCode());
            businessRelDomain.setDomainPosition(domain.getDomainPosition());
            businessRelDomainList.add(businessRelDomain);
        }
        return businessRelDomainList;
    }

    @Override
    public boolean delDomain(Business business, BusinessDomain domain) {
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
