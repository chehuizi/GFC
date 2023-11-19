package com.bmf.design.model.strategy.role.downstream;

import com.bmf.design.model.Domain;
import com.bmf.design.model.enums.RelationshipRoleEnum;

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
