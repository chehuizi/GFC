package com.bmf.infrastructure.dal;

import com.bmf.base.tactics.entity.DomainEntityAttr;

import java.util.List;

public interface DomainEntityAttrRepository extends BaseRepository<DomainEntityAttr> {

    /**
     * 根据实体ID查询属性列表
     * @param entityIdCode
     * @return
     */
    List<DomainEntityAttr> selectByEntityIdCode(Integer entityIdCode);
}