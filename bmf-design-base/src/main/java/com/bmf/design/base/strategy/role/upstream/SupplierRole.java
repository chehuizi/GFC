package com.bmf.design.base.strategy.role.upstream;

import com.bmf.design.base.Domain;
import com.bmf.design.base.enums.RelationshipRoleEnum;

/**
 * 供应商角色
 */
public class SupplierRole extends UpstreamRole {

    public SupplierRole() {
        super.setRole(RelationshipRoleEnum.SUPPLIER.getRole());
    }

    public SupplierRole(Domain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.SUPPLIER.getRole());
    }
}
