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
public class InclusionRelationship extends BusinessDomainRelationship<KernelRole, ShellRole> {

    public InclusionRelationship() {
        super.setRelationship(RelationshipEnum.KS.getType());
    }
}
