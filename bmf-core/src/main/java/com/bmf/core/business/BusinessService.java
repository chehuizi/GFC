package com.bmf.core.business;

import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.DO.BusinessRelDomainDO;

import java.util.List;

/**
 * 业务服务
 */
public interface BusinessService {

    /**
     * 添加业务
     * @param business
     * @return
     */
    boolean createBusiness(Business business);

    /**
     * 查询业务
     * @param business
     * @return
     */
    Business queryBusiness(Business business);

    /**
     * 查询业务关联领域
     * @param business
     * @return
     */
    List<BusinessRelDomainDO> queryBusinessRelDomain(Business business);

    /**
     * 添加领域
     * @param business
     * @param domain
     * @return
     */
    boolean addDomain(Business business, BusinessDomain domain);

    /**
     * 删除领域
     * @param business
     * @param domain
     * @return
     */
    boolean delDomain(Business business, BusinessDomain domain);
}
