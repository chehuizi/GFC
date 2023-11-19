package com.bmf.design.core.domain.impl;

import com.bmf.design.model.tactics.entity.DomainEntityRelVO;
import com.bmf.design.model.tactics.entity.DomainEntity;
import com.bmf.design.model.tactics.entity.DomainEntityAttr;
import com.bmf.design.model.tactics.valueobject.DomainValueObject;
import com.bmf.design.core.domain.DomainEntityService;
import com.bmf.design.infrastructure.dal.DomainEntityAttrRepository;
import com.bmf.design.infrastructure.dal.DomainEntityRelVORepository;
import com.bmf.design.infrastructure.dal.DomainEntityRepository;
import com.bmf.design.infrastructure.dal.DomainValueObjectRepository;
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
        List<DomainEntityRelVO> domainEntityRelVOList = domainEntityRelVORepository.selectByEntityIdCode(entityIdCode);
        if (Objects.isNull(domainEntityRelVOList) || domainEntityRelVOList.size() <= 0) {
            return null;
        }
        List<Integer> voCodeList = new ArrayList<>();
        for (DomainEntityRelVO domainEntityRelVO : domainEntityRelVOList) {
            voCodeList.add(domainEntityRelVO.getVoCode());
        }
        return domainValueObjectRepository.selectByVoCode(voCodeList);
    }

    @Override
    public DomainEntityRelVO queryEntityRelVO(Integer entityIdCode, Integer voCode) {
        DomainEntityRelVO domainEntityRelVO = new DomainEntityRelVO();
        domainEntityRelVO.setEntityIdCode(entityIdCode);
        domainEntityRelVO.setVoCode(voCode);
        return domainEntityRelVORepository.selectOne(domainEntityRelVO);
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
