package com.bmf.base.strategy.symmetric;

import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.base.strategy.role.partner.PartnerRole;
import lombok.Data;

/**
 * 对称关系：共享内核
 */
@Data
public class SharedKernel extends BusinessDomainRelationship<PartnerRole, PartnerRole> {

    public SharedKernel() {
        super.setRelationship(RelationshipEnum.SK.getType());
    }
}
