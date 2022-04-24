package com.bmf.domain.base.strategy.role.downstream;

import com.bmf.domain.base.BusinessDomain;
import com.bmf.domain.base.enums.RelationshipRoleEnum;

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
