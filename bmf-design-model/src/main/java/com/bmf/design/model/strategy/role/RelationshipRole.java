package com.bmf.design.model.strategy.role;

import com.bmf.design.model.Domain;
import com.bmf.design.model.enums.RelationshipRoleEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 关系角色
 */
@Data
@NoArgsConstructor
public class RelationshipRole {

    /**
     * 角色关联的业务域
     */
    private Domain domain;

    /**
     * 角色
     * @see RelationshipRoleEnum
     */
    private String role;
}
