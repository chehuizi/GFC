package com.bmf.base.strategy.role.partner;

import com.bmf.base.Domain;
import com.bmf.base.enums.RelationshipRoleEnum;
import com.bmf.base.strategy.role.RelationshipRole;

public class PartnerRole extends RelationshipRole {

    public PartnerRole() {
        super.setRole(RelationshipRoleEnum.PARTNER.getRole());
    }

    public PartnerRole(Domain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.PARTNER.getRole());
    }
}
