package com.bmf.core.domain;

import com.bmf.base.BusinessDomain;
import com.bmf.base.dsl.BusinessDslBase;
import com.bmf.base.dsl.BusinessDslExt;
import com.bmf.base.enums.CmdTypeEnum;

import java.util.List;
import java.util.Map;

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
     * 根据业务编码查询领域
     * @param businessCode
     * @return
     */
    List<BusinessDomain> queryDomainByBusinessCode(Integer businessCode);

    /**
     * 查询领域列表
     * @param domainCodeList
     * @return
     */
    List<BusinessDomain> queryDomainByCode(List<Integer> domainCodeList);

    /**
     * 根据领域别名查询
     * @param businessCode
     * @param domainAliasList
     * @return
     */
    List<BusinessDomain> queryDomainByAlias(Integer businessCode, List<String> domainAliasList);

    /**
     * 创建领域
     * @param businessDomain
     * @return
     */
    boolean createDomain(BusinessDomain businessDomain);

    /**
     * 批量创建领域
     * @param businessDomainList
     * @return
     */
    boolean batchCreateDomain(List<BusinessDomain> businessDomainList);

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

    /**
     * 处理战略设计
     * @param businessCode
     * @param domainList
     * @return
     */
    Map<Integer, CmdTypeEnum> handleStrategyDesign(Integer businessCode, List<BusinessDomain> domainList);
}
