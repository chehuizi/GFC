package com.bmf.base.strategy.role.upstream;

import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.RelationshipRoleEnum;

/**
 * 开放主机服务
 */
public class OpenHostService extends UpstreamRole {

    public OpenHostService() {
        super.setRole(RelationshipRoleEnum.OHS.getRole());
    }

    public OpenHostService(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.OHS.getRole());
    }
}
