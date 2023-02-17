package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainServiceAttrPO;

public interface BusinessDomainServiceAttrMapper {

    BusinessDomainServiceAttrPO selectOne(BusinessDomainServiceAttrPO businessDomainServiceAttrPO);

    int insert(BusinessDomainServiceAttrPO businessDomainEntityAttrPO);

    int update(BusinessDomainServiceAttrPO businessDomainEntityAttrPO);

    int delete(BusinessDomainServiceAttrPO businessDomainEntityAttrPO);

}
