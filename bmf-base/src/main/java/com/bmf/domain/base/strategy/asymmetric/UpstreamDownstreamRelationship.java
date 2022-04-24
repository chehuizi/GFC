package com.bmf.domain.base.strategy.asymmetric;

import com.bmf.domain.base.enums.RelationshipEnum;
import com.bmf.domain.base.strategy.role.downstream.DownstreamRole;
import com.bmf.domain.base.strategy.role.upstream.UpstreamRole;
import lombok.Data;

/**
 * 非对称关系：上下游关系
 */
@Data
public class UpstreamDownstreamRelationship extends AsymmetricRelationship {

    /**
     * 上游
     */
    private UpstreamRole upstream;
    /**
     * 下游
     */
    private DownstreamRole downstream;

    public UpstreamDownstreamRelationship() {
        super.setRelationship(RelationshipEnum.UD.getType());
        upstream = new UpstreamRole();
        downstream = new DownstreamRole();
    }

    @Override
    public String toString() {
        return "{" +
                "\"relationship\": \"" + super.getRelationship() + "\"" +
                ", \"upstream\": \"" + upstream.getDomain().getDomainName() + "\"" +
                ", \"upstreamRole\": \"" + upstream.getRole() + "\"" +
                ", \"downstream\": \"" + downstream.getDomain().getDomainName() + "\"" +
                ", \"downstreamRole\": \"" + downstream.getRole() + "\"" +
                "}";
    }
}
