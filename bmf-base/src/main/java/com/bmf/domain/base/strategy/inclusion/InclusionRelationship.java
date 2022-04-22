package com.bmf.domain.base.strategy.inclusion;

import com.bmf.domain.base.strategy.BusinessDomainRelationship;
import com.bmf.domain.base.strategy.role.KernelRole;
import com.bmf.domain.base.strategy.role.ShellRole;

/**
 * 包含关系
 */
public class InclusionRelationship extends BusinessDomainRelationship {

    /**
     * 包含角色
     */
    private ShellRole shell;
    /**
     * 被包含角色
     */
    private KernelRole kernel;

}
