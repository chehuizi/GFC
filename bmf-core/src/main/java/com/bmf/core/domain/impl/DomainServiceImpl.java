package com.bmf.core.domain.impl;

import com.bmf.base.BusinessDomain;
import com.bmf.base.dsl.BusinessDslBase;
import com.bmf.base.dsl.BusinessDslExt;
import com.bmf.core.domain.DomainService;
import com.bmf.infrastructure.dal.DomainRepository;
import com.bmf.infrastructure.dal.po.DomainPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainRepository domainRepository;

    @Override
    public BusinessDomain queryDomain(BusinessDomain businessDomain) {
        return domainRepository.selectOne(businessDomain);
    }

    @Override
    public List<BusinessDomain> queryDomainList(List<Integer> domainCodeList) {
        return domainRepository.selectList(domainCodeList);
    }

    @Override
    public boolean createDomain(BusinessDomain businessDomain) {
        boolean result = domainRepository.insert(businessDomain);
        return result;
    }

    @Override
    public boolean updateDomain(BusinessDomain businessDomain) {
        boolean result = domainRepository.update(businessDomain);
        return result;
    }

    @Override
    public boolean deleteDomain(BusinessDomain businessDomain) {
        return domainRepository.delete(businessDomain);
    }

    @Override
    public boolean addDsl(BusinessDslBase businessDslBase) {
        return false;
    }

    @Override
    public boolean delDsl(BusinessDslBase businessDslBase) {
        return false;
    }

    @Override
    public boolean addDslExt(BusinessDslExt businessDslExt) {
        return false;
    }

    @Override
    public boolean delDslExt(BusinessDslExt businessDslExt) {
        return false;
    }
}
