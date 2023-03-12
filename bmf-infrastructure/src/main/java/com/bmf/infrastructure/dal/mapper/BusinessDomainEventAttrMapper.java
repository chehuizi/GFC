package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainEventAttrPO;

import java.util.List;

public interface BusinessDomainEventAttrMapper {

    BusinessDomainEventAttrPO selectOne(BusinessDomainEventAttrPO businessDomainEventAttrPO);

    List<BusinessDomainEventAttrPO> selectByEventCode(Integer eventCode);

    int insert(BusinessDomainEventAttrPO businessDomainEventAttrPO);

    int update(BusinessDomainEventAttrPO businessDomainEventAttrPO);

    int delete(BusinessDomainEventAttrPO businessDomainEventAttrPO);

}
