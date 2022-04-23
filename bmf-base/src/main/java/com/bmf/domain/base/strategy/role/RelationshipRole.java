package com.bmf.domain.base.strategy.role;

import com.bmf.domain.base.BusinessDomain;
import lombok.Data;

/**
 * 关系角色
 */
@Data
public class RelationshipRole {

    /**
     * 角色关联的业务域
     */
    private BusinessDomain domain;

    /**
     * 角色
     */
    private String role;
}
