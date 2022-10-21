package com.bmf.core.business.impl;

import com.bmf.common.enums.BizCodeEnum;
import com.bmf.common.exception.BizException;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.core.business.BusinessService;
import com.bmf.infrastructure.dal.BusinessRelDomainRepository;
import com.bmf.infrastructure.dal.BusinessRepository;
import com.bmf.infrastructure.dal.po.BusinessPO;
import com.bmf.infrastructure.dal.utils.BusinessPOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessRepository businessRepository;
    @Autowired
    private BusinessRelDomainRepository businessRelDomainRepository;

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
