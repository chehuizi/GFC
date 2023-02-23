package com.bmf.core.domain.impl;

import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.base.tactics.valueobject.DomainValueObjectAttr;
import com.bmf.core.domain.DomainValueObjectService;
import com.bmf.infrastructure.dal.DomainValueObjectAttrRepository;
import com.bmf.infrastructure.dal.DomainValueObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainValueObjectServiceImpl implements DomainValueObjectService {

    @Autowired
    private DomainValueObjectRepository domainValueObjectRepository;
    @Autowired
    private DomainValueObjectAttrRepository domainValueObjectAttrRepository;

    @Override
    public Boolean addValueObjectAttr(DomainValueObjectAttr valueObjectAttr) {
        return domainValueObjectAttrRepository.insert(valueObjectAttr);
    }

    @Override
    public Boolean delValueObjectAttr(DomainValueObjectAttr valueObjectAttr) {
        return domainValueObjectAttrRepository.delete(valueObjectAttr);
    }
}
