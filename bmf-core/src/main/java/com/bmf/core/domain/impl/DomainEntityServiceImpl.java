package com.bmf.core.domain.impl;

import com.bmf.base.tactics.entity.EntityRelVO;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.core.domain.DomainEntityService;
import com.bmf.infrastructure.dal.DomainEntityAttrRepository;
import com.bmf.infrastructure.dal.DomainEntityRelVORepository;
import com.bmf.infrastructure.dal.DomainEntityRepository;
import com.bmf.infrastructure.dal.DomainValueObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DomainEntityServiceImpl implements DomainEntityService {

    @Autowired
    private DomainEntityRepository domainEntityRepository;
    @Autowired
    private DomainEntityAttrRepository domainEntityAttrRepository;
    @Autowired
    private DomainEntityRelVORepository domainEntityRelVORepository;
    @Autowired
    private DomainValueObjectRepository domainValueObjectRepository;

    @Override
    public DomainEntity queryDomainEntity(DomainEntity domainEntity) {
        return domainEntityRepository.selectOne(domainEntity);
    }

    @Override
    public List<DomainEntity> queryByDomainCode(Integer domainCode) {
        return domainEntityRepository.selectByDomainCode(domainCode);
    }

    @Override
    public List<DomainEntityAttr> queryEntityAttr(Integer entityIdCode) {
        return domainEntityAttrRepository.selectByEntityIdCode(entityIdCode);
    }

    @Override
    public List<DomainValueObject> queryEntityVO(Integer entityIdCode) {
        List<EntityRelVO> entityRelVOList = domainEntityRelVORepository.selectByEntityIdCode(entityIdCode);
        if (Objects.isNull(entityRelVOList) || entityRelVOList.size() <= 0) {
            return null;
        }
        List<Integer> voCodeList = new ArrayList<>();
        for (EntityRelVO entityRelVO : entityRelVOList) {
            voCodeList.add(entityRelVO.getVoCode());
        }
        return domainValueObjectRepository.selectByVoCode(voCodeList);
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
