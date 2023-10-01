package com.bmf.design.core.domain;

import com.bmf.design.base.dsl.BusinessDslExt;

import java.util.List;

/**
 * DSL服务
 */
public interface DslService {

    /**
     * 添加DSL扩展属性
     * @param dslExtList
     * @return
     */
    Boolean addDslExt(List<BusinessDslExt> dslExtList);



    /**
     * 删除DSL扩展属性
     * @param dslExt
     * @return
     */
    Boolean delDslExt(BusinessDslExt dslExt);
}
