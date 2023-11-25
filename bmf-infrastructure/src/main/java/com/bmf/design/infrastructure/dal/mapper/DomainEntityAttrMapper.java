package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.DomainEntityAttrPO;

import java.util.List;

public interface DomainEntityAttrMapper {

    DomainEntityAttrPO selectOne(DomainEntityAttrPO domainEntityAttrPO);

    List<DomainEntityAttrPO> selectByEntityIdCode(Integer entityIdCode);

    int insert(DomainEntityAttrPO domainEntityAttrPO);

    int update(DomainEntityAttrPO domainEntityAttrPO);

    int delete(DomainEntityAttrPO domainEntityAttrPO);

}
