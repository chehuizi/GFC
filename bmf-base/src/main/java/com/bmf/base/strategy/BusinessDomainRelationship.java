package com.bmf.base.strategy;

import com.bmf.base.BaseDO;
import com.bmf.base.strategy.role.RelationshipRole;
import lombok.Data;

/**
 * 业务域关系
 */
@Data
public class BusinessDomainRelationship extends BaseDO {

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
     * 角色A
     * @see com.bmf.base.strategy.role.RelationshipRole
     */
    private RelationshipRole roleA;
    /**
     * 角色B
     * @see com.bmf.base.strategy.role.RelationshipRole
     */
    private RelationshipRole roleB;

    @Override
    public String toString() {
        return "{" +
                "\"relationship\": \"" + relationship + "\"" +
                '}';
    }
}
