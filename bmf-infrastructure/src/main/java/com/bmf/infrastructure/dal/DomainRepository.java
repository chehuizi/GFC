package com.bmf.infrastructure.dal;

import com.bmf.base.BusinessDomain;
import com.bmf.infrastructure.dal.po.DomainPO;

import java.util.List;

public interface DomainRepository extends BaseRepository<BusinessDomain, DomainPO> {

    /**
     * 查询领域列表
     * @param domainCodeList
     * @return
     */
    List<DomainPO> selectList(List<Integer> domainCodeList);
}
