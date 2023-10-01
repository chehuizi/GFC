package com.bmf.design.base.strategy.symmetric;

import com.bmf.design.base.enums.RelationshipEnum;
import com.bmf.design.base.strategy.DomainRelationship;
import com.bmf.design.base.strategy.role.partner.PartnerRole;
import lombok.Data;

/**
 * 对称关系：合作伙伴
 */
@Data
public class Partnership extends DomainRelationship<PartnerRole, PartnerRole> {

    public Partnership() {
        super.setRelationship(RelationshipEnum.PS.getType());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
