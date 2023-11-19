package com.bmf.design.core.domain;

import com.bmf.design.model.tactics.service.DomainServiceAttr;
import com.bmf.design.model.tactics.service.DomainService;

import java.util.List;

/**
 * 领域服务服务
 */
public interface DomainServiceService {

    /**
     * 查询领域服务
     * @param domainService
     * @return
     */
    DomainService queryDomainService(DomainService domainService);

    /**
     * 根据领域编码查询服务列表
     * @param domainCode
     * @return
     */
    List<DomainService> queryByDomainCode(Integer domainCode);

    /**
     * 根据服务code查询属性
     * @param serviceCode
     * @return
     */
    List<DomainServiceAttr> queryServiceAttr(Integer serviceCode);

    /**
     * 添加服务属性
     * @param serviceAttr
     * @return
     */
    Boolean addServiceAttr(DomainServiceAttr serviceAttr);

    /**
     * 删除服务属性
     * @param serviceAttr
     * @return
     */
    Boolean delServiceAttr(DomainServiceAttr serviceAttr);
}
