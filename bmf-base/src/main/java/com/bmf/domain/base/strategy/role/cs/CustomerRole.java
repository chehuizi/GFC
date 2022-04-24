package com.bmf.domain.base.strategy.role.cs;

import com.bmf.domain.base.BusinessDomain;
import com.bmf.domain.base.enums.RelationshipRoleEnum;
import com.bmf.domain.base.strategy.role.RelationshipRole;

/**
 * 客户角色
 */
public class CustomerRole extends RelationshipRole {

    public CustomerRole() {
        super.setRole(RelationshipRoleEnum.CUSTOMER.getRole());
    }

    public CustomerRole(BusinessDomain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.CUSTOMER.getRole());
    }
}
