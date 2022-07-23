package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainValueObjectPO;

public interface BusinessDomainValueObjectMapper {

    BusinessDomainValueObjectPO selectOne(BusinessDomainValueObjectPO businessDomainValueObjectPO);

    int insert(BusinessDomainValueObjectPO businessDomainValueObjectPO);

    int update(BusinessDomainValueObjectPO businessDomainValueObjectPO);

    int delete(BusinessDomainValueObjectPO businessDomainValueObjectPO);

}
