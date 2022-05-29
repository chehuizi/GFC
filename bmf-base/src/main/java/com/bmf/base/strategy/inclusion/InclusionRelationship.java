package com.bmf.base.strategy.inclusion;

import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.base.strategy.role.inclusion.KernelRole;
import com.bmf.base.strategy.role.inclusion.ShellRole;
import lombok.Data;

/**
 * 包含关系
 */
@Data
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
