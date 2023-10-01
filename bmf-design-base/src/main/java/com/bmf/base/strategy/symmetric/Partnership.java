package com.bmf.base.strategy.symmetric;

import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.strategy.DomainRelationship;
import com.bmf.base.strategy.role.partner.PartnerRole;
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
