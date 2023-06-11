package com.bmf.base.strategy.role;

import com.bmf.base.BusinessDomain;
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
    private BusinessDomain domain;

    /**
     * 角色
     * @see com.bmf.base.enums.RelationshipRoleEnum
     */
    private String role;
}
