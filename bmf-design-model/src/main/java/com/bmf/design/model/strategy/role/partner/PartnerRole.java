package com.bmf.design.model.strategy.role.partner;

import com.bmf.design.model.Domain;
import com.bmf.design.model.enums.RelationshipRoleEnum;
import com.bmf.design.model.strategy.role.RelationshipRole;

public class PartnerRole extends RelationshipRole {

    public PartnerRole() {
        super.setRole(RelationshipRoleEnum.PARTNER.getRole());
    }

    public PartnerRole(Domain domain) {
        super.setDomain(domain);
        super.setRole(RelationshipRoleEnum.PARTNER.getRole());
    }
}
