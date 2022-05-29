package com.bmf.base.strategy.role.downstream;

import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.RelationshipRoleEnum;

/**
 * 防腐层
 */
public class AnticorruptionLayer extends DownstreamRole {

    public AnticorruptionLayer() {
        super.setRole(RelationshipRoleEnum.ACL.getRole());
    }

    public AnticorruptionLayer(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.ACL.getRole());
    }
}
