package com.bmf.domain.base;

import com.bmf.domain.base.enums.BusinessDomainLevelEnum;
import com.bmf.domain.base.enums.BusinessDomainTypeEnum;
import com.bmf.domain.base.enums.RelationshipEnum;
import com.bmf.domain.base.strategy.asymmetric.UpstreamDownstreamRelationship;
import com.bmf.domain.base.strategy.role.downstream.AnticorruptionLayer;
import com.bmf.domain.base.strategy.role.downstream.Conformist;
import com.bmf.domain.base.strategy.role.upstream.OpenHostService;
import com.bmf.domain.base.strategy.symmetric.Partnership;
import com.bmf.domain.base.strategy.symmetric.SharedKernel;
import org.junit.Test;

public class BusinessDomainMap4AsymmetricTest {

    @Test
    public void test_create_UD_OHS_CF() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_ims = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "ims");
        domainMap.addBusinessDomain(domain_ims);

        BusinessDomain domain_wms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "wms");
        domainMap.addBusinessDomain(domain_wms);

        UpstreamDownstreamRelationship upstreamDownstreamRelationship = new UpstreamDownstreamRelationship();
        upstreamDownstreamRelationship.setDomainA(domain_ims);
        upstreamDownstreamRelationship.setDomainB(domain_wms);
        upstreamDownstreamRelationship.setUpstream(new OpenHostService(domain_ims));
        upstreamDownstreamRelationship.setDownstream(new Conformist(domain_wms));
        domainMap.addBusinessDomainRelationship(upstreamDownstreamRelationship);

        System.out.println(domainMap);
    }

    @Test
    public void test_create_UD_OHS_ACL() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_tms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "tms");
        domainMap.addBusinessDomain(domain_tms);

        BusinessDomain domain_lc = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "lc");
        domainMap.addBusinessDomain(domain_lc);

        UpstreamDownstreamRelationship upstreamDownstreamRelationship = new UpstreamDownstreamRelationship();
        upstreamDownstreamRelationship.setDomainA(domain_tms);
        upstreamDownstreamRelationship.setDomainB(domain_lc);
        upstreamDownstreamRelationship.setUpstream(new OpenHostService(domain_tms));
        upstreamDownstreamRelationship.setDownstream(new AnticorruptionLayer(domain_lc));
        domainMap.addBusinessDomainRelationship(upstreamDownstreamRelationship);

        System.out.println(domainMap);
    }
}
