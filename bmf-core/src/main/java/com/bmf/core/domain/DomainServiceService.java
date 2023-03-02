package com.bmf.core.domain;

import com.bmf.base.tactics.service.DomainServiceAttr;
import com.bmf.base.tactics.service.DomainService;

import java.util.List;

/**
 * 领域服务服务
 */
public interface DomainServiceService {

    /**
     * 根据领域编码查询服务列表
     * @param domainCode
     * @return
     */
    List<DomainService> queryByDomainCode(Integer domainCode);
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
