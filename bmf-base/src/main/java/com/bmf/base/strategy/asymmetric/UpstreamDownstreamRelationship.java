package com.bmf.base.strategy.asymmetric;

import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.base.strategy.role.downstream.DownstreamRole;
import com.bmf.base.strategy.role.upstream.UpstreamRole;
import lombok.Data;

/**
 * 非对称关系：上下游关系
 */
@Data
public class UpstreamDownstreamRelationship extends BusinessDomainRelationship<UpstreamRole, DownstreamRole> {

    public UpstreamDownstreamRelationship() {
        super.setRelationship(RelationshipEnum.UD.getType());
    }

}
