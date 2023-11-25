package com.bmf.design.infrastructure.dal;

import com.bmf.design.model.dsl.BusinessDslExt;

import java.util.List;

public interface DslExtRepository extends BaseRepository<BusinessDslExt> {

    /**
     * 批量插入
     * @param dslExtList
     * @return
     */
    boolean batchInsert(List<BusinessDslExt> dslExtList);
}
