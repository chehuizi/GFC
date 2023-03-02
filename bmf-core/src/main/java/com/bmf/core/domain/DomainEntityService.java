package com.bmf.core.domain;

import com.bmf.base.tactics.entity.EntityRelVO;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;

import java.util.List;

/**
 * 领域实体服务
 */
public interface DomainEntityService {

    /**
     * 查询领域实体
     * @param domainEntity
     * @return
     */
    DomainEntity queryDomainEntity(DomainEntity domainEntity);

    /**
     * 根据领域编码查询实体列表
     * @param domainCode
     * @return
     */
    List<DomainEntity> queryByDomainCode(Integer domainCode);

    /**
     * 查询实体和值对象关系
     * @param entityIdCode
     * @param voCode
     * @return
     */
    EntityRelVO queryEntityRelVO(Integer entityIdCode, Integer voCode);

    /**
     * 添加实体属性
     * @param entityAttr
     * @return
     */
    Boolean addEntityAttr(DomainEntityAttr entityAttr);

    /**
     * 删除实体属性
     * @param entityAttr
     * @return
     */
    Boolean delEntityAttr(DomainEntityAttr entityAttr);
}
