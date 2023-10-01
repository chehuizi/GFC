package com.bmf.design.infrastructure.dal.mapper;

import com.bmf.design.infrastructure.dal.po.DomainServicePO;

import java.util.List;

public interface DomainServiceMapper {

    DomainServicePO selectOne(DomainServicePO domainServicePO);

    List<DomainServicePO> selectByDomainCode(Integer domainCode);

    int insert(DomainServicePO domainServicePO);

    int update(DomainServicePO domainServicePO);

    int delete(DomainServicePO domainServicePO);

}
