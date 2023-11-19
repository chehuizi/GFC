package com.bmf.design.model.strategy.role.downstream;

import com.bmf.design.model.Domain;
import com.bmf.design.model.enums.RelationshipRoleEnum;

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
