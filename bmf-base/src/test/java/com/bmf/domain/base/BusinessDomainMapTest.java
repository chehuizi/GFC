package com.bmf.domain.base;

import com.bmf.domain.base.enums.BusinessDomainLevelEnum;
import com.bmf.domain.base.enums.BusinessDomainTypeEnum;
import com.bmf.domain.base.enums.RelationshipEnum;
import com.bmf.domain.base.strategy.asymmetric.UpstreamDownstreamRelationship;
import com.bmf.domain.base.strategy.role.downstream.Conformist;
import com.bmf.domain.base.strategy.role.upstream.OpenHostService;
import com.bmf.domain.base.strategy.role.upstream.UpstreamRole;
import com.bmf.domain.base.strategy.symmetric.Partnership;
import com.bmf.domain.base.strategy.symmetric.SharedKernel;
import org.junit.Test;

public class BusinessDomainMapTest {

    @Test
    public void test_create_PS() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_wms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "wms");
        domainMap.addBusinessDomain(domain_wms);

        BusinessDomain domain_tms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "tms");
        domainMap.addBusinessDomain(domain_tms);

        Partnership partnership = new Partnership();
        partnership.setRelationship(RelationshipEnum.PS.getType());
        partnership.setDomainA(domain_wms);
        partnership.setDomainB(domain_tms);
        domainMap.addBusinessDomainRelationship(partnership);

        System.out.println(domainMap);
    }

    @Test
    public void test_create_SK() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_oms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "oms");
        domainMap.addBusinessDomain(domain_oms);

        BusinessDomain domain_ofc = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "ofc");
        domainMap.addBusinessDomain(domain_ofc);

        SharedKernel sharedKernel = new SharedKernel();
        sharedKernel.setRelationship(RelationshipEnum.SK.getType());
        sharedKernel.setDomainA(domain_oms);
        sharedKernel.setDomainB(domain_ofc);
        domainMap.addBusinessDomainRelationship(sharedKernel);

        System.out.println(domainMap);
    }

    @Test
    public void test_create_UD() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_ims = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "ims");
        domainMap.addBusinessDomain(domain_ims);

        BusinessDomain domain_wms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "wms");
        domainMap.addBusinessDomain(domain_wms);

        UpstreamDownstreamRelationship upstreamDownstreamRelationship = new UpstreamDownstreamRelationship();
        upstreamDownstreamRelationship.setRelationship(RelationshipEnum.UD.getType());
        upstreamDownstreamRelationship.setDomainA(domain_ims);
        upstreamDownstreamRelationship.setDomainB(domain_wms);
        OpenHostService openHostService = new OpenHostService();
        openHostService.setDomain(domain_ims);
        upstreamDownstreamRelationship.setUpstream(openHostService);
        Conformist conformist = new Conformist();
        conformist.setDomain(domain_wms);
        upstreamDownstreamRelationship.setDownstream(conformist);
        domainMap.addBusinessDomainRelationship(upstreamDownstreamRelationship);

        System.out.println(domainMap);
    }
}
