package com.bmf.infrastructure.dal;

import com.bmf.base.tactics.entity.EntityRelVO;

import java.util.List;

public interface DomainEntityRelVORepository extends BaseRepository<EntityRelVO> {

    /**
     * 根据实体ID查询VO
     * @param entityIdCode
     * @return
     */
    List<EntityRelVO> selectByEntityIdCode(Integer entityIdCode);
}