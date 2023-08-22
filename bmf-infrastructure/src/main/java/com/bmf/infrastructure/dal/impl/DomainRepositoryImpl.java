package com.bmf.infrastructure.dal.impl;

import com.bmf.base.BusinessDomain;
import com.bmf.infrastructure.dal.DomainRepository;
import com.bmf.infrastructure.dal.mapper.BusinessRelDomainMapper;
import com.bmf.infrastructure.dal.mapper.DomainMapper;
import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;
import com.bmf.infrastructure.dal.po.DomainPO;
import com.bmf.infrastructure.dal.utils.POUtils;
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
    public BusinessDomain selectOne(BusinessDomain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return POUtils.convert(domainMapper.selectOne(domainPO), BusinessDomain.class);
    }

    @Override
    public List<BusinessDomain> selectByDomainCode(List<Integer> domainCodeList) {
        return POUtils.convert(domainMapper.selectByDomainCode(domainCodeList), BusinessDomain.class);
    }

    @Override
    public List<BusinessDomain> selectByBusinessCode(Integer businessCode) {
        List<BusinessRelDomainPO> businessRelDomainPOList = businessRelDomainMapper.selectByBusinessCode(businessCode);
        return POUtils.convert(domainMapper.selectByDomainCode(businessRelDomainPOList.stream().
                        map(BusinessRelDomainPO::getDomainCode).collect(Collectors.toList())),
                BusinessDomain.class);
    }

    @Override
    public List<BusinessDomain> selectByDomainAlias(Integer businessCode, List<String> domainAliasList) {
        return POUtils.convert(domainMapper.selectByDomainAlias(businessCode, domainAliasList), BusinessDomain.class);
    }

    @Override
    public boolean insert(BusinessDomain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return domainMapper.insert(domainPO) == 1;
    }

    @Override
    public boolean batchInsert(List<BusinessDomain> businessDomainList) {
        List<DomainPO> domainPOList = POUtils.convertModel2PO(businessDomainList, DomainPO.class);
        return domainMapper.batchInsert(domainPOList) == businessDomainList.size();
    }

    @Override
    public boolean update(BusinessDomain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return domainMapper.update(domainPO) == 1;
    }

    @Override
    public boolean batchUpdate(List<BusinessDomain> businessDomainList) {
        List<DomainPO> domainPOList = POUtils.convertModel2PO(businessDomainList, DomainPO.class);
        return domainMapper.batchUpdate(domainPOList) == businessDomainList.size();
    }

    @Override
    public boolean delete(BusinessDomain req) {
        DomainPO domainPO = POUtils.convert(req, DomainPO.class);
        return domainMapper.delete(domainPO) == 1;
    }

    @Override
    public boolean batchDelete(List<BusinessDomain> businessDomainList) {
        List<DomainPO> domainPOList = POUtils.convertModel2PO(businessDomainList, DomainPO.class);
        return domainMapper.batchDelete(domainPOList) == domainPOList.size();
    }
}
