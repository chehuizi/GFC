package com.bmf.base.strategy.role.inclusion;

import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.RelationshipRoleEnum;
import com.bmf.base.strategy.role.RelationshipRole;

/**
 * 包含角色
 */
public class ShellRole extends RelationshipRole {

    public ShellRole() {
        super.setRole(RelationshipRoleEnum.SHELL.getRole());
    }

    public ShellRole(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.SHELL.getRole());
    }
}
