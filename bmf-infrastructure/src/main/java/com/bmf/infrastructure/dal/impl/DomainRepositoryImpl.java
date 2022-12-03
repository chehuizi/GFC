package com.bmf.infrastructure.dal.impl;

import com.bmf.base.BusinessDomain;
import com.bmf.infrastructure.dal.DomainRepository;
import com.bmf.infrastructure.dal.mapper.DomainMapper;
import com.bmf.infrastructure.dal.po.DomainPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DomainRepositoryImpl implements DomainRepository {

    @Resource
    private DomainMapper domainMapper;

    @Override
    public DomainPO selectOne(BusinessDomain req) {
        return domainMapper.selectOne(DomainPOUtil.convert(req));
    }

    @Override
    public List<DomainPO> selectList(List<Integer> domainCodeList) {
        return domainMapper.selectList(domainCodeList);
    }

    @Override
    public boolean insert(BusinessDomain req) {
        return domainMapper.insert(DomainPOUtil.convert(req)) > 0;
    }

    @Override
    public boolean update(BusinessDomain req) {
        return domainMapper.update(DomainPOUtil.convert(req)) > 0;
    }

    @Override
    public boolean delete(BusinessDomain req) {
        return domainMapper.delete(DomainPOUtil.convert(req)) > 0;
    }
}
