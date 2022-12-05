package com.bmf.infrastructure.dal;

import com.bmf.base.BusinessRelDomain;
import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;

import java.util.List;

public interface BusinessRelDomainRepository extends BaseRepository<BusinessRelDomain, BusinessRelDomainPO> {

    /**
     * 查询业务下的领域列表
     * @param req
     * @return
     */
    List<BusinessRelDomainPO> selectList(BusinessRelDomain req);
}
