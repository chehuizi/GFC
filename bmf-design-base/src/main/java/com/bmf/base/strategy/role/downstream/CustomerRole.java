package com.bmf.base.strategy.role.downstream;

import com.bmf.base.Domain;
import com.bmf.base.enums.RelationshipRoleEnum;

/**
 * 客户角色
 */
public class CustomerRole extends DownstreamRole {

    public CustomerRole() {
        super.setRole(RelationshipRoleEnum.CUSTOMER.getRole());
    }

    public CustomerRole(Domain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.CUSTOMER.getRole());
    }
}
