package com.bmf.domain.base.strategy.asymmetric;

import com.bmf.domain.base.strategy.BusinessDomainRelationship;
import com.bmf.domain.base.strategy.role.downstream.DownstreamRole;
import com.bmf.domain.base.strategy.role.upstream.UpstreamRole;

/**
 * 非对称关系：上下游关系
 */
public class UpstreamDownstreamRelationship extends BusinessDomainRelationship {

    /**
     * 上游
     */
    private UpstreamRole upstream;
    /**
     * 下游
     */
    private DownstreamRole downstream;
}
