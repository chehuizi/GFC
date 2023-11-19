package com.bmf.design.core.domain;

import com.bmf.common.utils.exception.BizException;
import com.bmf.design.model.Domain;
import com.bmf.design.model.dsl.BusinessDslBase;
import com.bmf.design.model.dsl.BusinessDslExt;
import com.bmf.design.model.enums.CmdTypeEnum;

import java.util.List;
import java.util.Map;

/**
 * 业务领域服务
 */
public interface DomainService {

    /**
     * 查询领域
     * @param domain
     * @return
     */
    Domain queryDomain(Domain domain);

    /**
     * 根据业务编码查询领域
     * @param businessCode
     * @return
     */
    List<Domain> queryDomainByBusinessCode(Integer businessCode);

    /**
     * 查询领域列表
     * @param domainCodeList
     * @return
     */
    List<Domain> queryDomainByCode(List<Integer> domainCodeList);

    /**
     * 创建领域
     * @param domain
     * @return
     */
    boolean createDomain(Domain domain);

    /**
     * 批量创建领域
     * @param domainList
     * @return
     */
    boolean batchCreateDomain(List<Domain> domainList);

    /**
     * 更新领域
     * @param domain
     * @return
     */
    boolean updateDomain(Domain domain);

    /**
     * 删除领域
     * @param domain
     * @return
     */
    boolean deleteDomain(Domain domain);

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
    Map<CmdTypeEnum, List<Domain>> handleStrategyDesign(Integer businessCode,
                                                        List<Domain> domainList)
            throws BizException;
}
