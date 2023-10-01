package com.bmf.core.domain.impl;

import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.service.DomainServiceAttr;
import com.bmf.core.domain.DomainServiceService;
import com.bmf.infrastructure.dal.DomainServiceAttrRepository;
import com.bmf.infrastructure.dal.DomainServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainServiceServiceImpl implements DomainServiceService {

    @Autowired
    private DomainServiceRepository domainServiceRepository;
    @Autowired
    private DomainServiceAttrRepository domainServiceAttrRepository;

    @Override
    public DomainService queryDomainService(DomainService domainService) {
        return domainServiceRepository.selectOne(domainService);
    }

    @Override
    public List<DomainService> queryByDomainCode(Integer domainCode) {
        return domainServiceRepository.selectByDomainCode(domainCode);
    }

    @Override
    public List<DomainServiceAttr> queryServiceAttr(Integer serviceCode) {
        return domainServiceAttrRepository.selectByServiceCode(serviceCode);
    }

    @Override
    public Boolean addServiceAttr(DomainServiceAttr serviceAttr) {
        return domainServiceAttrRepository.insert(serviceAttr);
    }

    @Override
    public Boolean delServiceAttr(DomainServiceAttr serviceAttr) {
        return domainServiceAttrRepository.delete(serviceAttr);
    }
}
