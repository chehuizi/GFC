package com.bmf.core.domain;

import com.bmf.base.tactics.service.DomainServiceAttr;

/**
 * 领域服务服务
 */
public interface DomainServiceService {

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
