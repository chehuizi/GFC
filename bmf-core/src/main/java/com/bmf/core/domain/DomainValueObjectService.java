package com.bmf.core.domain;

import com.bmf.base.tactics.valueobject.DomainValueObjectAttr;

/**
 * 领域值对象服务
 */
public interface DomainValueObjectService {

    /**
     * 添加值对象属性
     * @param valueObjectAttr
     * @return
     */
    Boolean addValueObjectAttr(DomainValueObjectAttr valueObjectAttr);

    /**
     * 删除值对象属性
     * @param valueObjectAttr
     * @return
     */
    Boolean delValueObjectAttr(DomainValueObjectAttr valueObjectAttr);
}
