package com.bmf.base.strategy.role.partner;

import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.RelationshipRoleEnum;
import com.bmf.base.strategy.role.RelationshipRole;

public class SharedKernelRole extends RelationshipRole {

    public SharedKernelRole() {
        super.setRole(RelationshipRoleEnum.SHARED_KERNEL.getRole());
    }

    public SharedKernelRole(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.SHARED_KERNEL.getRole());
    }
}
