package com.bmf.base.strategy.symmetric;

import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.base.strategy.role.partner.PartnerRole;

/**
 * 对称关系：合作伙伴
 */
public class Partnership extends BusinessDomainRelationship<PartnerRole, PartnerRole> {

    @Override
    public String toString() {
        return super.toString();
    }

    public Partnership() {
        super.setRelationship(RelationshipEnum.PS.getType());
    }
}
