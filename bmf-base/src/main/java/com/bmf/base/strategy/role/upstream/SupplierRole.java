package com.bmf.base.strategy.role.upstream;

import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.RelationshipRoleEnum;
import com.bmf.base.strategy.role.RelationshipRole;
import com.bmf.base.strategy.role.upstream.UpstreamRole;

/**
 * 供应商角色
 */
public class SupplierRole extends UpstreamRole {

    public SupplierRole() {
        super.setRole(RelationshipRoleEnum.SUPPLIER.getRole());
    }

    public SupplierRole(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.SUPPLIER.getRole());
    }
}
