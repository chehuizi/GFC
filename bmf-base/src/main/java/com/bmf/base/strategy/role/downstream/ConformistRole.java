package com.bmf.base.strategy.role.downstream;

import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.RelationshipRoleEnum;

/**
 * 遵从者
 */
public class ConformistRole extends DownstreamRole {

    public ConformistRole() {
        super.setRole(RelationshipRoleEnum.CF.getRole());
    }

    public ConformistRole(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.CF.getRole());
    }
}
