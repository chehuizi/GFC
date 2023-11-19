package com.bmf.design.core.domain;

import com.bmf.design.model.tactics.entity.DomainEntityRelVO;
import com.bmf.design.model.tactics.entity.DomainEntity;
import com.bmf.design.model.tactics.entity.DomainEntityAttr;
import com.bmf.design.model.tactics.valueobject.DomainValueObject;

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
     * 根据实体ID查询实体属性
     * @param entityIdCode
     * @return
     */
    List<DomainEntityAttr> queryEntityAttr(Integer entityIdCode);

    /**
     * 根据实体ID查询值对象
     * @param entityIdCode
     * @return
     */
    List<DomainValueObject> queryEntityVO(Integer entityIdCode);

    /**
     * 查询实体和值对象关系
     * @param entityIdCode
     * @param voCode
     * @return
     */
    DomainEntityRelVO queryEntityRelVO(Integer entityIdCode, Integer voCode);

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
