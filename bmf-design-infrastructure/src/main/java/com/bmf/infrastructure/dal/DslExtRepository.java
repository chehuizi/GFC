package com.bmf.infrastructure.dal;

import com.bmf.base.dsl.BusinessDslExt;

import java.util.List;

public interface DslExtRepository extends BaseRepository<BusinessDslExt> {

    /**
     * 批量插入
     * @param dslExtList
     * @return
     */
    boolean batchInsert(List<BusinessDslExt> dslExtList);
}
