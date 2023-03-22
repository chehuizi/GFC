package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.BusinessDomainEntityAttrPO;

import java.util.List;

public interface BusinessDomainEntityAttrMapper {

    BusinessDomainEntityAttrPO selectOne(BusinessDomainEntityAttrPO businessDomainEntityAttrPO);

    List<BusinessDomainEntityAttrPO> selectByEntityIdCode(Integer entityIdCode);

    int insert(BusinessDomainEntityAttrPO businessDomainEntityAttrPO);

    int update(BusinessDomainEntityAttrPO businessDomainEntityAttrPO);

    int delete(BusinessDomainEntityAttrPO businessDomainEntityAttrPO);

}
