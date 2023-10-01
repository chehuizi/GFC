package com.bmf.design.base.strategy.role.downstream;

import com.bmf.design.base.Domain;
import com.bmf.design.base.enums.RelationshipRoleEnum;

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
