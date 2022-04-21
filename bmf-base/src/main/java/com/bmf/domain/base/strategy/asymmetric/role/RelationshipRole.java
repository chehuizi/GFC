package com.bmf.domain.base.strategy.asymmetric.role;

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

}
