package com.bmf.design.base.strategy.asymmetric;

import com.bmf.design.base.enums.RelationshipEnum;
import com.bmf.design.base.strategy.DomainRelationship;
import com.bmf.design.base.strategy.role.downstream.DownstreamRole;
import com.bmf.design.base.strategy.role.upstream.UpstreamRole;
import lombok.Data;

/**
 * 非对称关系：普通上下游关系
 */
@Data
public class UpstreamDownstreamRelationship extends DomainRelationship<UpstreamRole, DownstreamRole> {

    public UpstreamDownstreamRelationship() {
        super.setRelationship(RelationshipEnum.UD.getType());
    }

}
