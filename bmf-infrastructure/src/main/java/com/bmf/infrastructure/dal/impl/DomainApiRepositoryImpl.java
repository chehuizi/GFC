package com.bmf.infrastructure.dal.impl;

import com.bmf.base.application.DomainApi;
import com.bmf.infrastructure.dal.DomainApiRepository;
import com.bmf.infrastructure.dal.mapper.DomainApiMapper;
import com.bmf.infrastructure.dal.po.DomainApiPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainApiRepositoryImpl implements DomainApiRepository {

    @Autowired
    private DomainApiMapper domainApiMapper;

    @Override
    public DomainApi selectOne(DomainApi req) {
        return null;
    }

    @Override
    public List<DomainApi> selectByDomainCode(Integer domainCode) {
        return POUtils.convert(domainApiMapper.selectByDomainCode(domainCode), DomainApi.class);
    }

    @Override
    public boolean insert(DomainApi req) {
        return false;
    }

    @Override
    public boolean batchInsert(List<DomainApi> req) {
        List<DomainApiPO> domainApiPOList = POUtils.convertModel2PO(req, DomainApiPO.class);
        return domainApiMapper.batchInsert(domainApiPOList) == req.size();
    }

    @Override
    public boolean update(DomainApi req) {
        return false;
    }

    @Override
    public boolean delete(DomainApi req) {
        return false;
    }
}
