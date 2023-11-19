package com.bmf.design.model.strategy.asymmetric;

import com.bmf.design.model.enums.RelationshipEnum;
import com.bmf.design.model.strategy.DomainRelationship;
import com.bmf.design.model.strategy.role.downstream.DownstreamRole;
import com.bmf.design.model.strategy.role.upstream.UpstreamRole;
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
