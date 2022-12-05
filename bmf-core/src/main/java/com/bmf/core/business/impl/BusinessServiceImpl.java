package com.bmf.core.business.impl;

import com.bmf.base.BusinessDomainRelation;
import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.exception.BizException;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.common.utils.BusinessUtil;
import com.bmf.core.business.BusinessService;
import com.bmf.infrastructure.dal.BusinessDomainRelationRepository;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.BusinessRepository;
import com.bmf.infrastructure.dal.po.BusinessDomainRelationPO;
import com.bmf.infrastructure.dal.po.BusinessPO;
import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;
import com.bmf.infrastructure.dal.utils.BusinessPOUtil;
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
        BusinessPO businessPO = businessRepository.selectOne(business);
        return BusinessPOUtil.convert(businessPO);
    }

    @Override
    public List<BusinessRelDomainDO> queryBusinessRelDomain(Business business) {
        BusinessRelDomainDO businessRelDomainDO = BusinessUtil.convert(business);
        List<BusinessRelDomainPO> businessRelDomainPOList = businessRelDomainRepository.selectList(businessRelDomainDO);
        return BusinessPOUtil.convert(businessRelDomainPOList);
    }

    @Override
    public List<BusinessDomainRelation> queryBusinessDomainRelation(Business business) {
        BusinessDomainRelation businessDomainRelation = BusinessUtil.convertDR(business);
        List<BusinessDomainRelationPO> businessDomainRelationPOList = businessDomainRelationRepository.selectList(businessDomainRelation);
        return BusinessPOUtil.convertDR(businessDomainRelationPOList);
    }

    @Override
    public boolean addDomain(Business business, BusinessDomain domain) {
        BusinessRelDomainDO businessRelDomainDO = new BusinessRelDomainDO();
        businessRelDomainDO.setBusinessCode(business.getBusinessCode());
        businessRelDomainDO.setDomainCode(domain.getDomainCode());
        return businessRelDomainRepository.insert(businessRelDomainDO);
    }

    @Override
    public boolean delDomain(Business business, BusinessDomain domain) {
        BusinessRelDomainDO businessRelDomainDO = new BusinessRelDomainDO();
        businessRelDomainDO.setBusinessCode(business.getBusinessCode());
        businessRelDomainDO.setDomainCode(domain.getDomainCode());
        return businessRelDomainRepository.delete(businessRelDomainDO);
    }
}
