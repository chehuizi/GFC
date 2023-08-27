package com.bmf.base.strategy;

import com.bmf.base.BaseModel;
import com.bmf.base.strategy.role.RelationshipRole;
import lombok.Data;

/**
 * 业务域关系
 */
@Data
public class BusinessDomainRelationship<T extends RelationshipRole, R extends RelationshipRole> extends BaseModel {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 领域关系
     * @see com.bmf.base.enums.RelationshipEnum
     */
    private String relationship;
    /**
     * @see RelationshipRole
     */
    private T roleA;
    /**
     * @see RelationshipRole
     */
    private R roleB;

    @Override
    public String toString() {
        return "{" +
                "\"businessCode\": \"" + businessCode + "\"" +
                "\"relationship\": \"" + relationship + "\"" +
                "\"roleA\": \"" + roleA.getRole() + "\"" +
                "\"roleB\": \"" + roleB.getRole() + "\"" +
                '}';
    }

    protected BusinessDomainRelationship() {
    }
}
