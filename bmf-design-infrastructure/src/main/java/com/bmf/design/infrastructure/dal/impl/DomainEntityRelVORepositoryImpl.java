package com.bmf.design.infrastructure.dal.impl;

import com.bmf.design.model.tactics.entity.DomainEntityRelVO;
import com.bmf.design.infrastructure.dal.mapper.DomainEntityRelVOMapper;
import com.bmf.design.infrastructure.dal.utils.POUtils;
import com.bmf.design.infrastructure.dal.DomainEntityRelVORepository;
import com.bmf.design.infrastructure.dal.po.DomainEntityRelVOPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainEntityRelVORepositoryImpl implements DomainEntityRelVORepository {

    @Autowired
    private DomainEntityRelVOMapper domainEntityRelVOMapper;

    @Override
    public DomainEntityRelVO selectOne(DomainEntityRelVO req) {
        DomainEntityRelVOPO entityRelVOPO = POUtils.convert(req, DomainEntityRelVOPO.class);
        return POUtils.convert(domainEntityRelVOMapper.selectOne(entityRelVOPO), DomainEntityRelVO.class);
    }

    @Override
    public List<DomainEntityRelVO> selectByEntityIdCode(Integer entityIdCode) {
        return POUtils.convert(domainEntityRelVOMapper.selectByEntityIdCode(entityIdCode), DomainEntityRelVO.class);
    }

    @Override
    public boolean insert(DomainEntityRelVO req) {
        DomainEntityRelVOPO entityRelVOPO = POUtils.convert(req, DomainEntityRelVOPO.class);
        return domainEntityRelVOMapper.insert(entityRelVOPO) == 1;
    }

    @Override
    public boolean update(DomainEntityRelVO req) {
        return false;
    }

    @Override
    public boolean delete(DomainEntityRelVO req) {
        DomainEntityRelVOPO entityRelVOPO = POUtils.convert(req, DomainEntityRelVOPO.class);
        return domainEntityRelVOMapper.delete(entityRelVOPO) == 1;
    }
}
