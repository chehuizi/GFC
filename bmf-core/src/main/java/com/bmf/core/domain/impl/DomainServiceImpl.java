package com.bmf.core.domain.impl;

import com.bmf.base.BusinessDomain;
import com.bmf.core.domain.DomainService;
import com.bmf.infrastructure.dal.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainRepository domainRepository;

    @Override
    public boolean create(BusinessDomain businessDomain) {
        boolean result = domainRepository.insert(businessDomain);
        return result;
    }

}
