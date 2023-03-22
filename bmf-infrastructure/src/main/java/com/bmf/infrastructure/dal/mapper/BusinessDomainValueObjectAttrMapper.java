package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainValueObjectAttrPO;

public interface BusinessDomainValueObjectAttrMapper {

    BusinessDomainValueObjectAttrPO selectOne(BusinessDomainValueObjectAttrPO businessDomainValueObjectAttrPO);

    int insert(BusinessDomainValueObjectAttrPO businessDomainValueObjectAttrPO);

    int update(BusinessDomainValueObjectAttrPO businessDomainValueObjectAttrPO);

    int delete(BusinessDomainValueObjectAttrPO businessDomainValueObjectAttrPO);

}
