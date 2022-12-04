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
public class UpstreamDownstreamRelationship<T extends UpstreamRole, R extends DownstreamRole> extends BusinessDomainRelationship<T, R> {

    public UpstreamDownstreamRelationship() {
        super.setRelationship(RelationshipEnum.UD.getType());
    }

}
