package com.bmf.design.model.strategy.symmetric;

import com.bmf.design.model.enums.RelationshipEnum;
import com.bmf.design.model.strategy.DomainRelationship;
import com.bmf.design.model.strategy.role.partner.PartnerRole;
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
