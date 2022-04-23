package com.bmf.domain.base.strategy.role.upstream;

import com.bmf.domain.base.enums.RelationshipRoleEnum;

/**
 * 开放主机服务
 */
public class OpenHostService extends UpstreamRole {

    public OpenHostService() {
        super.setRole(RelationshipRoleEnum.OHS.getRole());
    }
}
