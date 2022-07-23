package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainEntityAttrPO;

public interface BusinessDomainEntityAttrMapper {

    BusinessDomainEntityAttrPO selectOne(BusinessDomainEntityAttrPO businessDomainEntityAttrPO);

    int insert(BusinessDomainEntityAttrPO businessDomainEntityAttrPO);

    int update(BusinessDomainEntityAttrPO businessDomainEntityAttrPO);

    int delete(BusinessDomainEntityAttrPO businessDomainEntityAttrPO);

}
