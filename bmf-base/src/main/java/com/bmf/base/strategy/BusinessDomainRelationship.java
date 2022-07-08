package com.bmf.base.strategy;

import com.bmf.base.strategy.role.RelationshipRole;
import lombok.Data;

/**
 * 业务域关系
 */
@Data
public class BusinessDomainRelationship {

    /**
     * 领域关系
     * @see com.bmf.base.enums.RelationshipEnum
     */
    private String relationship;

    @Override
    public String toString() {
        return "{" +
                "\"relationship\": \"" + relationship + "\"" +
                '}';
    }
}
