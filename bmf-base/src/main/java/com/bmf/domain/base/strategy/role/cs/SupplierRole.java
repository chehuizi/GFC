package com.bmf.domain.base.strategy.role.cs;

import com.bmf.domain.base.BusinessDomain;
import com.bmf.domain.base.enums.RelationshipRoleEnum;
import com.bmf.domain.base.strategy.role.RelationshipRole;

/**
 * 供应商角色
 */
public class SupplierRole extends RelationshipRole {

    public SupplierRole() {
        super.setRole(RelationshipRoleEnum.SUPPLIER.getRole());
    }

    public SupplierRole(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.SUPPLIER.getRole());
    }
}
