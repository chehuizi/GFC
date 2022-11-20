package com.bmf.core.domain.impl;

import com.bmf.base.BusinessDomain;
import com.bmf.core.domain.DomainService;
import com.bmf.infrastructure.dal.DomainRepository;
import com.bmf.infrastructure.dal.po.DomainPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainRepository domainRepository;

    @Override
    public boolean createDomain(BusinessDomain businessDomain) {
        boolean result = domainRepository.insert(businessDomain);
        return result;
    }

    @Override
    public BusinessDomain queryDomain(BusinessDomain businessDomain) {
        DomainPO domainPO = domainRepository.selectOne(businessDomain);
        return DomainPOUtil.convert(domainPO);
    }

    @Override
    public boolean deleteDomain(BusinessDomain businessDomain) {
        return domainRepository.delete(businessDomain);
    }
}
