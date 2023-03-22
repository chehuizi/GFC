package com.bmf.base.strategy.role.inclusion;

import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.RelationshipRoleEnum;
import com.bmf.base.strategy.role.RelationshipRole;

/**
 * 被包含角色
 */
public class KernelRole extends RelationshipRole {

    public KernelRole() {
        super.setRole(RelationshipRoleEnum.KERNEL.getRole());
    }

    public KernelRole(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.KERNEL.getRole());
    }
}
