package com.bmf.infrastructure.dal;

import com.bmf.base.BusinessRelDomain;

import java.util.List;

public interface BusinessRelDomainRepository extends BaseRepository<BusinessRelDomain> {

    /**
     * 查询业务下的领域列表
     * @param req
     * @return
     */
    List<BusinessRelDomain> selectList(BusinessRelDomain req);

    /**
     * 批量插入业务领域关系
     * @param businessRelDomainList
     * @return
     */
    boolean batchInsert(List<BusinessRelDomain> businessRelDomainList);
}
