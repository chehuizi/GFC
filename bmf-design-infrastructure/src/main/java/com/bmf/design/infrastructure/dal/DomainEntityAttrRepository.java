package com.bmf.design.infrastructure.dal;

import com.bmf.design.base.tactics.entity.DomainEntityAttr;

import java.util.List;

public interface DomainEntityAttrRepository extends BaseRepository<DomainEntityAttr> {

    /**
     * 根据实体ID查询属性列表
     * @param entityIdCode
     * @return
     */
    List<DomainEntityAttr> selectByEntityIdCode(Integer entityIdCode);
}