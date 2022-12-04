package com.bmf.base.strategy.asymmetric;

import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.base.strategy.role.cs.CustomerRole;
import com.bmf.base.strategy.role.cs.SupplierRole;
import lombok.Data;

/**
 * 非对称关系：客户/供应商关系
 */
@Data
public class CustomerSupplierRelationship extends BusinessDomainRelationship<SupplierRole, CustomerRole> {

    public CustomerSupplierRelationship() {
        super.setRelationship(RelationshipEnum.CS.getType());
    }

}
