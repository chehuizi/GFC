package com.bmf.base.strategy.symmetric;

import com.bmf.base.enums.RelationshipEnum;

/**
 * 对称关系：合作伙伴
 */
public class Partnership extends SymmetricRelationship {

    @Override
    public String toString() {
        return super.toString();
    }

    public Partnership() {
        super.setRelationship(RelationshipEnum.PS.getType());
    }
}
