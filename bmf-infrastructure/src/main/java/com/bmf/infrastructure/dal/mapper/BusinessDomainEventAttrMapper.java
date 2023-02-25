package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainEventAttrPO;

public interface BusinessDomainEventAttrMapper {

    BusinessDomainEventAttrPO selectOne(BusinessDomainEventAttrPO businessDomainEventAttrPO);

    int insert(BusinessDomainEventAttrPO businessDomainEventAttrPO);

    int update(BusinessDomainEventAttrPO businessDomainEventAttrPO);

    int delete(BusinessDomainEventAttrPO businessDomainEventAttrPO);

}
