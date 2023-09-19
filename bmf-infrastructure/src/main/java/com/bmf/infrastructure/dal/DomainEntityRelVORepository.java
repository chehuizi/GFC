package com.bmf.infrastructure.dal;

import com.bmf.base.tactics.entity.DomainEntityRelVO;

import java.util.List;

public interface DomainEntityRelVORepository extends BaseRepository<DomainEntityRelVO> {

    /**
     * 根据实体ID查询VO
     * @param entityIdCode
     * @return
     */
    List<DomainEntityRelVO> selectByEntityIdCode(Integer entityIdCode);
}