package com.bmf.design.model.strategy.symmetric;

import com.bmf.design.model.enums.RelationshipEnum;
import com.bmf.design.model.strategy.DomainRelationship;
import com.bmf.design.model.strategy.role.partner.PartnerRole;
import lombok.Data;

/**
 * 对称关系：共享内核
 */
@Data
public class SharedKernel extends DomainRelationship<PartnerRole, PartnerRole> {

    public SharedKernel() {
        super.setRelationship(RelationshipEnum.SK.getType());
    }
}
