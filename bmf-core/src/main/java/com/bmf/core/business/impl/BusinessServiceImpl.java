package com.bmf.core.business.impl;

import com.bmf.base.BusinessDomainRelation;
import com.bmf.base.flow.BusinessRole;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.exception.BizException;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.BusinessRelDomain;
import com.bmf.core.utils.BusinessUtil;
import com.bmf.core.business.BusinessService;
import com.bmf.infrastructure.dal.BusinessDomainRelationRepository;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.BusinessRepository;
import com.bmf.infrastructure.dal.BusinessRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Business queryBusiness(Business business) {
        return businessRepository.selectOne(business);
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
    public boolean addDomain(Business business, BusinessDomain domain) {
        BusinessRelDomain businessRelDomain = new BusinessRelDomain();
        businessRelDomain.setBusinessCode(business.getBusinessCode());
        businessRelDomain.setDomainCode(domain.getDomainCode());
        return businessRelDomainRepository.insert(businessRelDomain);
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
