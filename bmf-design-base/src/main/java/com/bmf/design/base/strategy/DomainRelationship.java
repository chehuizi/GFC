package com.bmf.design.base.strategy;

import com.bmf.design.base.BaseModel;
import com.bmf.design.base.strategy.role.RelationshipRole;
import com.bmf.design.base.enums.RelationshipEnum;
import lombok.Data;

/**
 * 业务域关系
 */
@Data
public class DomainRelationship<T extends RelationshipRole, R extends RelationshipRole> extends BaseModel {

    /**
     * 业务编码
     */
    private Integer businessCode;
    /**
     * 领域关系
     * @see RelationshipEnum
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

    protected DomainRelationship() {
    }
}
