package com.bmf.core.domain.impl;

import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.dsl.BusinessDslBase;
import com.bmf.base.dsl.BusinessDslExt;
import com.bmf.core.domain.DomainService;
import com.bmf.infrastructure.dal.DomainRepository;
import com.bmf.infrastructure.dal.DslBaseRepository;
import com.bmf.infrastructure.dal.DslExtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private DslBaseRepository dslBaseRepository;
    @Autowired
    private DslExtRepository dslExtRepository;

    @Override
    public BusinessDomain queryDomain(BusinessDomain businessDomain) {
        return domainRepository.selectOne(businessDomain);
    }

    @Override
    public List<BusinessDomain> queryDomainByBusinessCode(Integer businessCode) {
        return domainRepository.selectByBusinessCode(businessCode);
    }

    @Override
    public List<BusinessDomain> queryDomainByCode(List<Integer> domainCodeList) {
        return domainRepository.selectByDomainCode(domainCodeList);
    }

    @Override
    public List<BusinessDomain> queryDomainByAlias(Integer businessCode, List<String> domainAliasList) {
        return domainRepository.selectByDomainAlias(businessCode, domainAliasList);
    }

    @Override
    public boolean createDomain(BusinessDomain businessDomain) {
        return domainRepository.insert(businessDomain);
    }

    @Override
    public boolean batchCreateDomain(List<BusinessDomain> businessDomainList) {
        return domainRepository.batchInsert(businessDomainList);
    }

    @Override
    public boolean updateDomain(BusinessDomain businessDomain) {
        return domainRepository.update(businessDomain);
    }

    @Override
    public boolean deleteDomain(BusinessDomain businessDomain) {
        return domainRepository.delete(businessDomain);
    }

    @Override
    public boolean addDsl(BusinessDslBase businessDslBase) {
        boolean baseResult = dslBaseRepository.insert(businessDslBase);
        if (baseResult && Objects.nonNull(businessDslBase.getDslExtList())
                && businessDslBase.getDslExtList().size() > 0) {
        }
        return baseResult;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean delDsl(BusinessDslBase businessDslBase) {
        boolean delBase = dslBaseRepository.delete(businessDslBase);
        if (delBase) {
            boolean delExt = dslExtRepository.delete(null);
        }
        return false;
    }

    @Override
    public boolean addDslExt(BusinessDslExt businessDslExt) {
        return dslExtRepository.insert(businessDslExt);
    }

    @Override
    public boolean delDslExt(BusinessDslExt businessDslExt) {
        return dslExtRepository.delete(businessDslExt);
    }
}
