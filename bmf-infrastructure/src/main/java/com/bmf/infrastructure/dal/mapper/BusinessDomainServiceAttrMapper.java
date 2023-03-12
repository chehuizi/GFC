package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainServiceAttrPO;

import java.util.List;

public interface BusinessDomainServiceAttrMapper {

    BusinessDomainServiceAttrPO selectOne(BusinessDomainServiceAttrPO businessDomainServiceAttrPO);

    List<BusinessDomainServiceAttrPO> selectByServiceCode(Integer serviceCode);

    int insert(BusinessDomainServiceAttrPO businessDomainEntityAttrPO);

    int update(BusinessDomainServiceAttrPO businessDomainEntityAttrPO);

    int delete(BusinessDomainServiceAttrPO businessDomainEntityAttrPO);

}
