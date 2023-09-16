package com.bmf.infrastructure.dal.mapper;

import com.bmf.infrastructure.dal.po.DomainServiceAttrPO;

import java.util.List;

public interface DomainServiceAttrMapper {

    DomainServiceAttrPO selectOne(DomainServiceAttrPO domainServiceAttrPO);

    List<DomainServiceAttrPO> selectByServiceCode(Integer serviceCode);

    int insert(DomainServiceAttrPO businessDomainEntityAttrPO);

    int update(DomainServiceAttrPO businessDomainEntityAttrPO);

    int delete(DomainServiceAttrPO businessDomainEntityAttrPO);

}
