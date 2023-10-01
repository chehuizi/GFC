package com.bmf.design.base.strategy.asymmetric;

import com.bmf.design.base.enums.RelationshipEnum;
import com.bmf.design.base.strategy.DomainRelationship;
import com.bmf.design.base.strategy.role.downstream.CustomerRole;
import com.bmf.design.base.strategy.role.upstream.SupplierRole;
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
