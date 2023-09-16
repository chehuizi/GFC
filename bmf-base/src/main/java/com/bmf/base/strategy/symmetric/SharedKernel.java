package com.bmf.base.strategy.symmetric;

import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.strategy.DomainRelationship;
import com.bmf.base.strategy.role.partner.PartnerRole;
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
