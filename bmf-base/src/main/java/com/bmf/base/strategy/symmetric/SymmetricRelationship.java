package com.bmf.base.strategy.symmetric;

import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.base.strategy.role.partner.PartnerRole;

/**
 * 对称关系
 */
public class SymmetricRelationship extends BusinessDomainRelationship {

    /**
     * 领域A
     */
    private PartnerRole domainA;
    /**
     * 领域B
     */
    private PartnerRole domainB;

    @Override
    public String toString() {
        return super.toString();
    }
}
