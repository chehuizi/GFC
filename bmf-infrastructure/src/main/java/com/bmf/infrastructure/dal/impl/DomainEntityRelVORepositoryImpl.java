package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.EntityRelVO;
import com.bmf.infrastructure.dal.DomainEntityRelVORepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEntityRelVOMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEntityRelVOPO;
import com.bmf.infrastructure.dal.utils.DomainPOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DomainEntityRelVORepositoryImpl implements DomainEntityRelVORepository {

    @Resource
    private BusinessDomainEntityRelVOMapper domainEntityRelVOMapper;

    @Override
    public BusinessDomainEntityRelVOPO selectOne(EntityRelVO req) {
        return null;
    }

    @Override
    public boolean insert(EntityRelVO req) {
        BusinessDomainEntityRelVOPO entityRelVOPO = DomainPOUtil.convert(req, BusinessDomainEntityRelVOPO.class);
        return domainEntityRelVOMapper.insert(entityRelVOPO) == 1;
    }

    @Override
    public boolean update(EntityRelVO req) {
        return false;
    }

    @Override
    public boolean delete(EntityRelVO req) {
        BusinessDomainEntityRelVOPO entityRelVOPO = DomainPOUtil.convert(req, BusinessDomainEntityRelVOPO.class);
        return domainEntityRelVOMapper.delete(entityRelVOPO) == 1;
    }
}
