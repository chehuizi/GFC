package com.bmf.design.base.strategy.role.downstream;

import com.bmf.design.base.Domain;
import com.bmf.design.base.enums.RelationshipRoleEnum;

/**
 * 防腐层
 */
public class AnticorruptionLayerRole extends DownstreamRole {

    public AnticorruptionLayerRole() {
        super.setRole(RelationshipRoleEnum.ACL.getRole());
    }

    public AnticorruptionLayerRole(Domain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.ACL.getRole());
    }
}
