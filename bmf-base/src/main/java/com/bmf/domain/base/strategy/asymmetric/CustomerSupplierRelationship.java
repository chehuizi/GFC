package com.bmf.domain.base.strategy.asymmetric;

import com.bmf.domain.base.strategy.asymmetric.role.CustomerRole;
import com.bmf.domain.base.strategy.asymmetric.role.SupplierRole;

/**
 * 非对称关系：客户/供应商关系
 */
public class CustomerSupplierRelationship extends AsymmetricRelationship {

    /**
     * 上游
     */
    private CustomerRole customer;
    /**
     * 下游
     */
    private SupplierRole supplier;
}
