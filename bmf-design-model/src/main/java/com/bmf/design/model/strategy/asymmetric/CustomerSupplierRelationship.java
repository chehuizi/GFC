package com.bmf.design.model.strategy.asymmetric;

import com.bmf.design.model.enums.RelationshipEnum;
import com.bmf.design.model.strategy.DomainRelationship;
import com.bmf.design.model.strategy.role.downstream.CustomerRole;
import com.bmf.design.model.strategy.role.upstream.SupplierRole;
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
