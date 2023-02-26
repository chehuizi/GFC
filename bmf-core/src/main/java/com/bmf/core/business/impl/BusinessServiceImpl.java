package com.bmf.core.business.impl;

import com.bmf.base.BusinessDomainRelation;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.exception.BizException;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.BusinessRelDomain;
import com.bmf.common.utils.BusinessUtil;
import com.bmf.core.business.BusinessService;
import com.bmf.infrastructure.dal.BusinessDomainRelationRepository;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.BusinessRepository;
import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;
import com.bmf.infrastructure.dal.po.BusinessPO;
import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;
import com.bmf.infrastructure.dal.utils.POUtils;
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

    @Override
    public boolean createBusiness(Business business) {
        if (Objects.isNull(business)) {
            throw new BizException(BizCodeEnum.BUSINESS_NOT_EXIST);
        }
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
        List<BusinessDomainRelationPO> businessDomainRelationPOList = businessDomainRelationRepository.selectList(businessDomainRelation);
        return POUtils.convert(businessDomainRelationPOList, BusinessDomainRelation.class);
    }

    @Override
    public List<BusinessDomainRelation> queryBusinessDomainRelation(Business business, BusinessDomain domain) {
        BusinessDomainRelation businessDomainRelation = BusinessUtil.convertDR(business, domain);
        List<BusinessDomainRelationPO> businessDomainRelationPOList = businessDomainRelationRepository.selectByDomain(businessDomainRelation);
        return POUtils.convert(businessDomainRelationPOList, BusinessDomainRelation.class);
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
}
