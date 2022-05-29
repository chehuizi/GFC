package com.bmf.base.strategy.role.downstream;

import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.RelationshipRoleEnum;

/**
 * 遵从者
 */
public class Conformist extends DownstreamRole {

    public Conformist() {
        super.setRole(RelationshipRoleEnum.CF.getRole());
    }

    public Conformist(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.CF.getRole());
    }
}
