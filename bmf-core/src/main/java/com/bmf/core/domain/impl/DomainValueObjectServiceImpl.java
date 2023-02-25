package com.bmf.core.domain.impl;

import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.base.tactics.valueobject.DomainValueObjectAttr;
import com.bmf.core.domain.DomainValueObjectService;
import com.bmf.infrastructure.dal.DomainValueObjectAttrRepository;
import com.bmf.infrastructure.dal.DomainValueObjectRepository;
import com.bmf.infrastructure.dal.po.BusinessDomainValueObjectPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DomainValueObjectServiceImpl implements DomainValueObjectService {

    @Autowired
    private DomainValueObjectRepository domainValueObjectRepository;
    @Autowired
    private DomainValueObjectAttrRepository domainValueObjectAttrRepository;

    @Override
    public DomainValueObject queryDomainValueObject(DomainValueObject domainValueObject) {
        BusinessDomainValueObjectPO domainValueObjectPO = domainValueObjectRepository.selectOne(domainValueObject);
        if (Objects.isNull(domainValueObjectPO)) {
            return null;
        }
        return DomainPOUtil.convert(domainValueObjectPO);
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
