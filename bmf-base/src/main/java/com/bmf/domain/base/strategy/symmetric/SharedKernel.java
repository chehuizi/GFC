package com.bmf.domain.base.strategy.symmetric;

import com.bmf.domain.base.enums.RelationshipEnum;

/**
 * 对称关系：共享内核
 */
public class SharedKernel extends SymmetricRelationship {

    @Override
    public String toString() {
        return super.toString();
    }

    public SharedKernel() {
        super.setRelationship(RelationshipEnum.SK.getType());
    }
}
