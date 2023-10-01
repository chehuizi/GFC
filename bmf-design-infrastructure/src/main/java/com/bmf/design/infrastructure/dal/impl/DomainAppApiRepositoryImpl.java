package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.base.application.DomainAppApi;
import com.bmf.design.infrastructure.dal.mapper.DomainAppApiMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.DomainAppApiRepository;
import com.bmf.design.infrastructure.dal.po.DomainAppApiPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainAppApiRepositoryImpl implements DomainAppApiRepository {

    @Autowired
    private DomainAppApiMapper domainAppApiMapper;

    @Override
    public DomainAppApi selectOne(DomainAppApi req) {
        return null;
    }

    @Override
    public List<DomainAppApi> selectByDomainCode(Integer domainCode) {
        return POUtils.convert(domainAppApiMapper.selectByDomainCode(domainCode), DomainAppApi.class);
    }

    @Override
    public boolean insert(DomainAppApi req) {
        return false;
    }

    @Override
    public boolean batchInsert(List<DomainAppApi> req) {
        List<DomainAppApiPO> domainAppApiPOList = POUtils.convertModel2PO(req, DomainAppApiPO.class);
        return domainAppApiMapper.batchInsert(domainAppApiPOList) == req.size();
    }

    @Override
    public boolean update(DomainAppApi req) {
        return false;
    }

    @Override
    public boolean delete(DomainAppApi req) {
        return false;
    }
}
