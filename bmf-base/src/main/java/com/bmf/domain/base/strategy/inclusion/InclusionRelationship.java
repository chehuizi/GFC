package com.bmf.domain.base.strategy.inclusion;

import com.bmf.domain.base.enums.RelationshipEnum;
import com.bmf.domain.base.strategy.BusinessDomainRelationship;
import com.bmf.domain.base.strategy.role.inclusion.KernelRole;
import com.bmf.domain.base.strategy.role.inclusion.ShellRole;

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

    @Override
    public String toString() {
        return "{" +
                "\"relationship\": \"" + super.getRelationship() + "\"" +
                ", \"shell\": \"" + shell.getDomain().getDomainName() + "\"" +
                ", \"kernel\": \"" + kernel.getDomain().getDomainName() + "\"" +
                '}';
    }

    public InclusionRelationship() {
        super.setRelationship(RelationshipEnum.KS.getType());
        shell = new ShellRole();
        kernel = new KernelRole();
    }
}
