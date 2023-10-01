package com.bmf.base.strategy.role.downstream;

import com.bmf.base.Domain;
import com.bmf.base.enums.RelationshipRoleEnum;

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
