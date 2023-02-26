package com.bmf.core.domain.impl;

import com.bmf.base.BusinessDomain;
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
        DomainPO domainPO = domainRepository.selectOne(businessDomain);
        return POUtils.convert(domainPO, BusinessDomain.class);
    }

    @Override
    public List<BusinessDomain> queryDomainList(List<Integer> domainCodeList) {
        List<DomainPO> domainPOList = domainRepository.selectList(domainCodeList);
        return POUtils.convert(domainPOList, BusinessDomain.class);
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
}
