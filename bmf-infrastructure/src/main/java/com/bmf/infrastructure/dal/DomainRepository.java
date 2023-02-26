package com.bmf.infrastructure.dal;

import com.bmf.base.BusinessDomain;

import java.util.List;

public interface DomainRepository extends BaseRepository<BusinessDomain, BusinessDomain> {

    /**
     * 查询领域列表
     * @param domainCodeList
     * @return
     */
    List<BusinessDomain> selectList(List<Integer> domainCodeList);
}
