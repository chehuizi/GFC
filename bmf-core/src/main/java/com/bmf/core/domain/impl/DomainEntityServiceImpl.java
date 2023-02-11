package com.bmf.core.domain.impl;

import com.bmf.base.tactics.entity.BusinessDomainEntity;
import com.bmf.core.domain.DomainEntityService;
import com.bmf.infrastructure.dal.BusinessDomainEntityRepository;
import com.bmf.infrastructure.dal.po.BusinessDomainEntityPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DomainEntityServiceImpl implements DomainEntityService {

    @Autowired
    private BusinessDomainEntityRepository businessDomainEntityRepository;

    @Override
    public BusinessDomainEntity queryDomainEntity(BusinessDomainEntity domainEntity) {
        BusinessDomainEntityPO domainEntityPO = businessDomainEntityRepository.selectOne(domainEntity);
        if (Objects.isNull(domainEntityPO)) {
            return null;
        }
        return DomainPOUtil.convert(domainEntityPO);
    }

}
