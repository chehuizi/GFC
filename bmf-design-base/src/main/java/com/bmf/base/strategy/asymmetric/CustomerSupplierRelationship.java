package com.bmf.base.strategy.asymmetric;

import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.strategy.DomainRelationship;
import com.bmf.base.strategy.role.downstream.CustomerRole;
import com.bmf.base.strategy.role.upstream.SupplierRole;
import lombok.Data;

/**
 * 非对称关系：客户/供应商关系
 */
@Data
public class CustomerSupplierRelationship extends DomainRelationship<SupplierRole, CustomerRole> {

    public CustomerSupplierRelationship() {
        super.setRelationship(RelationshipEnum.CS.getType());
    }

}
