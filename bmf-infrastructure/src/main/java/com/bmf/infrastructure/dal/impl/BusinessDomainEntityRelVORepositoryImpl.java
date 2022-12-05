package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.EntityRelVO;
import com.bmf.infrastructure.dal.BusinessDomainEntityRelVORepository;
import com.bmf.infrastructure.dal.mapper.BusinessDomainEntityRelVOMapper;
import com.bmf.infrastructure.dal.po.BusinessDomainEntityRelVOPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BusinessDomainEntityRelVORepositoryImpl implements BusinessDomainEntityRelVORepository {

    @Resource
    private BusinessDomainEntityRelVOMapper businessDomainEntityRelVOMapper;

    @Override
    public BusinessDomainEntityRelVOPO selectOne(EntityRelVO req) {
        return null;
    }

    @Override
    public boolean insert(EntityRelVO req) {
        return false;
    }

    @Override
    public boolean update(EntityRelVO req) {
        return false;
    }

    @Override
    public boolean delete(EntityRelVO req) {
        return false;
    }
}
