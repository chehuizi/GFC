package com.bmf.design.infrastructure.dal;

import com.bmf.design.model.tactics.entity.DomainEntityRelVO;

import java.util.List;

public interface DomainEntityRelVORepository extends BaseRepository<DomainEntityRelVO> {

    /**
     * 根据实体ID查询VO
     * @param entityIdCode
     * @return
     */
    List<DomainEntityRelVO> selectByEntityIdCode(Integer entityIdCode);
}