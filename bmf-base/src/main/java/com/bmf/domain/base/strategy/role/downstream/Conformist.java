package com.bmf.domain.base.strategy.role.downstream;

import com.bmf.domain.base.BusinessDomain;
import com.bmf.domain.base.enums.RelationshipRoleEnum;

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
