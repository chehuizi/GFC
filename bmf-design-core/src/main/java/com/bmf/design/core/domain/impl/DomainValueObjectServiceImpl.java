package com.bmf.design.core.domain.impl;

import com.bmf.design.model.tactics.valueobject.DomainValueObject;
import com.bmf.design.model.tactics.valueobject.DomainValueObjectAttr;
import com.bmf.design.core.domain.DomainValueObjectService;
import com.bmf.design.infrastructure.dal.DomainValueObjectAttrRepository;
import com.bmf.design.infrastructure.dal.DomainValueObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainValueObjectServiceImpl implements DomainValueObjectService {

    @Autowired
    private DomainValueObjectRepository domainValueObjectRepository;
    @Autowired
    private DomainValueObjectAttrRepository domainValueObjectAttrRepository;

    @Override
    public DomainValueObject queryDomainValueObject(DomainValueObject domainValueObject) {
        return domainValueObjectRepository.selectOne(domainValueObject);
    }

    @Override
    public Boolean addValueObjectAttr(DomainValueObjectAttr valueObjectAttr) {
        return domainValueObjectAttrRepository.insert(valueObjectAttr);
    }

    @Override
    public Boolean delValueObjectAttr(DomainValueObjectAttr valueObjectAttr) {
        return domainValueObjectAttrRepository.delete(valueObjectAttr);
    }
}
