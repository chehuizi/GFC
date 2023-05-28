package com.bmf.infrastructure.dal;

import com.bmf.base.BusinessDomain;

import java.util.List;

public interface DomainRepository extends BaseRepository<BusinessDomain> {

    /**
     * 查询领域列表
     * @param domainCodeList
     * @return
     */
    List<BusinessDomain> selectList(List<Integer> domainCodeList);

    /**
     * 批量插入领域
     * @param businessDomainList
     * @return
     */
    boolean batchInsert(List<BusinessDomain> businessDomainList);
}
