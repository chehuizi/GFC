package com.bmf.infrastructure.dal;

import com.bmf.base.DO.BusinessRelDomainDO;
import com.bmf.infrastructure.dal.po.BusinessRelDomainPO;

import java.util.List;

public interface BusinessRelDomainRepository extends BaseRepository<BusinessRelDomainDO, BusinessRelDomainPO> {

    /**
     * 查询业务下的领域列表
     * @param req
     * @return
     */
    List<BusinessRelDomainPO> selectList(BusinessRelDomainDO req);
}
