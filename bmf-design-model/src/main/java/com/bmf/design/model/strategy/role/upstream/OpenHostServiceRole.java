package com.bmf.design.model.strategy.role.upstream;

import com.bmf.design.model.Domain;
import com.bmf.design.model.enums.RelationshipRoleEnum;

/**
 * 开放主机服务
 */
public class OpenHostServiceRole extends UpstreamRole {

    public OpenHostServiceRole() {
        super.setRole(RelationshipRoleEnum.OHS.getRole());
    }

    public OpenHostServiceRole(Domain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.OHS.getRole());
    }
}
