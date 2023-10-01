package com.bmf.base.strategy.role.upstream;

import com.bmf.base.Domain;
import com.bmf.base.enums.RelationshipRoleEnum;

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
