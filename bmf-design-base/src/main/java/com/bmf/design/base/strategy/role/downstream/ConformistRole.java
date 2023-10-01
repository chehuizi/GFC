package com.bmf.design.base.strategy.role.downstream;

import com.bmf.design.base.Domain;
import com.bmf.design.base.enums.RelationshipRoleEnum;

/**
 * 遵从者
 */
public class ConformistRole extends DownstreamRole {

    public ConformistRole() {
        super.setRole(RelationshipRoleEnum.CF.getRole());
    }

    public ConformistRole(Domain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.CF.getRole());
    }
}
