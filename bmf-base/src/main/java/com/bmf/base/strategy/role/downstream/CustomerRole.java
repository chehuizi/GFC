package com.bmf.base.strategy.role.downstream;

import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.RelationshipRoleEnum;
import com.bmf.base.strategy.role.RelationshipRole;
import com.bmf.base.strategy.role.downstream.DownstreamRole;

/**
 * 客户角色
 */
public class CustomerRole extends DownstreamRole {

    public CustomerRole() {
        super.setRole(RelationshipRoleEnum.CUSTOMER.getRole());
    }

    public CustomerRole(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.CUSTOMER.getRole());
    }
}
