package com.bmf.core.domain.impl;

import com.bmf.base.tactics.entity.EntityRelVO;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.core.domain.DomainEntityService;
import com.bmf.infrastructure.dal.DomainEntityAttrRepository;
import com.bmf.infrastructure.dal.DomainEntityRelVORepository;
import com.bmf.infrastructure.dal.DomainEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomainEntityServiceImpl implements DomainEntityService {

    @Autowired
    private DomainEntityRepository domainEntityRepository;
    @Autowired
    private DomainEntityAttrRepository domainEntityAttrRepository;
    @Autowired
    private DomainEntityRelVORepository domainEntityRelVORepository;

    @Override
    public DomainEntity queryDomainEntity(DomainEntity domainEntity) {
        return domainEntityRepository.selectOne(domainEntity);
    }

    @Override
    public List<DomainEntity> queryByDomainCode(Integer domainCode) {
        return null;
    }

    @Override
    public EntityRelVO queryEntityRelVO(Integer entityIdCode, Integer voCode) {
        EntityRelVO entityRelVO = new EntityRelVO();
        entityRelVO.setEntityIdCode(entityIdCode);
        entityRelVO.setVoCode(voCode);
        return domainEntityRelVORepository.selectOne(entityRelVO);
    }

    @Override
    public Boolean addEntityAttr(DomainEntityAttr entityAttr) {
        return domainEntityAttrRepository.insert(entityAttr);
    }

    @Override
    public Boolean delEntityAttr(DomainEntityAttr entityAttr) {
        return domainEntityAttrRepository.delete(entityAttr);
    }
}
