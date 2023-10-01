package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.base.DomainRelation;
import com.bmf.design.infrastructure.dal.mapper.DomainRelationMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.DomainRelationRepository;
import com.bmf.design.infrastructure.dal.po.DomainRelationPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainRelationRepositoryImpl implements DomainRelationRepository {

    @Autowired
    private DomainRelationMapper domainRelationMapper;

    @Override
    public DomainRelation selectOne(DomainRelation req) {
        return null;
    }

    @Override
    public List<DomainRelation> selectByBusinessCode(Integer businessCode) {
        return POUtils.convert(domainRelationMapper.selectByBusinessCode(businessCode), DomainRelation.class);
    }

    @Override
    public List<DomainRelation> selectByDomain(DomainRelation req) {
        DomainRelationPO domainRelationPO = POUtils.convert(req, DomainRelationPO.class);
        return POUtils.convert(domainRelationMapper.selectByDomain(domainRelationPO), DomainRelation.class);
    }

    @Override
    public boolean insert(DomainRelation req) {
        DomainRelationPO domainRelationPO = POUtils.convert(req, DomainRelationPO.class);
        return domainRelationMapper.insert(domainRelationPO) == 1;
    }

    @Override
    public boolean batchInsert(List<DomainRelation> domainRelationList) {
        List<DomainRelationPO> domainRelationPOList = POUtils.convertModel2PO(domainRelationList,
                DomainRelationPO.class);
        int num = domainRelationMapper.batchInsert(domainRelationPOList);
        return num >= domainRelationList.size() && num <= 2 * domainRelationList.size();
    }

    @Override
    public boolean update(DomainRelation req) {
        return false;
    }

    @Override
    public boolean delete(DomainRelation req) {
        DomainRelationPO domainRelationPO = POUtils.convert(req, DomainRelationPO.class);
        return domainRelationMapper.delete(domainRelationPO) == 1;
    }

    @Override
    public boolean deleteByBusinessCode(Integer businessCode) {
        return domainRelationMapper.deleteByBusinessCode(businessCode) >= 0;
    }
}
