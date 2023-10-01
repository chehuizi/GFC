package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.base.Domain;
import com.bmf.design.infrastructure.dal.mapper.BusinessRelDomainMapper;
import com.bmf.design.infrastructure.dal.mapper.DomainMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.DomainRepository;
import com.bmf.design.infrastructure.dal.po.BusinessRelDomainPO;
import com.bmf.design.infrastructure.dal.po.DomainPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainRepositoryImpl implements DomainRepository {

    @Autowired
    private DomainMapper domainMapper;
    @Autowired
    private BusinessRelDomainMapper businessRelDomainMapper;

    @Override
    public Domain selectOne(Domain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return POUtils.convert(domainMapper.selectOne(domainPO), Domain.class);
    }

    @Override
    public List<Domain> selectByDomainCode(List<Integer> domainCodeList) {
        return POUtils.convert(domainMapper.selectByDomainCode(domainCodeList), Domain.class);
    }

    @Override
    public List<Domain> selectByBusinessCode(Integer businessCode) {
        List<BusinessRelDomainPO> businessRelDomainPOList = businessRelDomainMapper.selectByBusinessCode(businessCode);
        return POUtils.convert(domainMapper.selectByDomainCode(businessRelDomainPOList.stream().
                        map(BusinessRelDomainPO::getDomainCode).collect(Collectors.toList())),
                Domain.class);
    }

    @Override
    public boolean insert(Domain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return domainMapper.insert(domainPO) == 1;
    }

    @Override
    public boolean batchInsert(List<Domain> domainList) {
        List<DomainPO> domainPOList = POUtils.convertModel2PO(domainList, DomainPO.class);
        return domainMapper.batchInsert(domainPOList) == domainList.size();
    }

    @Override
    public boolean update(Domain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return domainMapper.update(domainPO) == 1;
    }

    @Override
    public boolean batchUpdate(List<Domain> domainList) {
        List<DomainPO> domainPOList = POUtils.convertModel2PO(domainList, DomainPO.class);
        return domainMapper.batchUpdate(domainPOList) == domainList.size();
    }

    @Override
    public boolean delete(Domain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return domainMapper.delete(domainPO) == 1;
    }

    @Override
    public boolean batchDelete(List<Domain> domainList) {
        List<DomainPO> domainPOList = POUtils.convertModel2PO(domainList, DomainPO.class);
        return domainMapper.batchDelete(domainPOList) == domainPOList.size();
    }
}
