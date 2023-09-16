package com.bmf.infrastructure.dal.impl;

import com.bmf.base.tactics.entity.EntityRelVO;
import com.bmf.infrastructure.dal.DomainEntityRelVORepository;
import com.bmf.infrastructure.dal.mapper.DomainEntityRelVOMapper;
import com.bmf.infrastructure.dal.po.DomainEntityRelVOPO;
import com.bmf.infrastructure.dal.utils.POUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainEntityRelVORepositoryImpl implements DomainEntityRelVORepository {

    @Autowired
    private DomainEntityRelVOMapper domainEntityRelVOMapper;

    @Override
    public EntityRelVO selectOne(EntityRelVO req) {
        DomainEntityRelVOPO entityRelVOPO = POUtils.convert(req, DomainEntityRelVOPO.class);
        return POUtils.convert(domainEntityRelVOMapper.selectOne(entityRelVOPO), EntityRelVO.class);
    }

    @Override
    public List<EntityRelVO> selectByEntityIdCode(Integer entityIdCode) {
        return POUtils.convert(domainEntityRelVOMapper.selectByEntityIdCode(entityIdCode), EntityRelVO.class);
    }

    @Override
    public boolean insert(EntityRelVO req) {
        DomainEntityRelVOPO entityRelVOPO = POUtils.convert(req, DomainEntityRelVOPO.class);
        return domainEntityRelVOMapper.insert(entityRelVOPO) == 1;
    }

    @Override
    public boolean update(EntityRelVO req) {
        return false;
    }

    @Override
    public boolean delete(EntityRelVO req) {
        DomainEntityRelVOPO entityRelVOPO = POUtils.convert(req, DomainEntityRelVOPO.class);
        return domainEntityRelVOMapper.delete(entityRelVOPO) == 1;
    }
}
