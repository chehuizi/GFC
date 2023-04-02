package com.bmf.core.domain;

import com.bmf.base.BusinessDomain;
import com.bmf.base.dsl.BusinessDslBase;
import com.bmf.base.dsl.BusinessDslExt;

import java.util.List;

/**
 * 业务领域服务
 */
public interface DomainService {

    /**
     * 查询领域
     * @param businessDomain
     * @return
     */
    BusinessDomain queryDomain(BusinessDomain businessDomain);

    /**
     * 查询领域列表
     * @param domainCodeList
     * @return
     */
    List<BusinessDomain> queryDomainList(List<Integer> domainCodeList);

    /**
     * 创建领域
     * @param businessDomain
     * @return
     */
    boolean createDomain(BusinessDomain businessDomain);

    /**
     * 更新领域
     * @param businessDomain
     * @return
     */
    boolean updateDomain(BusinessDomain businessDomain);

    /**
     * 删除领域
     * @param businessDomain
     * @return
     */
    boolean deleteDomain(BusinessDomain businessDomain);

    /**
     * 添加领域术语
     * @param businessDslBase
     * @return
     */
    boolean addDsl(BusinessDslBase businessDslBase);

    /**
     * 删除领域术语
     * @param businessDslBase
     * @return
     */
    boolean delDsl(BusinessDslBase businessDslBase);

    /**
     * 添加领域术语扩展属性
     * @param businessDslExt
     * @return
     */
    boolean addDslExt(BusinessDslExt businessDslExt);

    /**
     * 删除领域术语扩展属性
     * @param businessDslExt
     * @return
     */
    boolean delDslExt(BusinessDslExt businessDslExt);
}
