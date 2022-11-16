package com.bmf.base;

import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.base.strategy.asymmetric.CustomerSupplierRelationship;
import com.bmf.base.strategy.asymmetric.UpstreamDownstreamRelationship;
import com.bmf.base.strategy.role.cs.CustomerRole;
import com.bmf.base.strategy.role.cs.SupplierRole;
import com.bmf.base.strategy.role.downstream.AnticorruptionLayer;
import com.bmf.base.strategy.role.downstream.Conformist;
import com.bmf.base.strategy.role.upstream.OpenHostService;
import com.bmf.base.strategy.role.upstream.PublishedLanguage;
import org.junit.Test;

public class BusinessDomainMap4AsymmetricTest {

    @Test
    public void test_create_UD_OHS_CF() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_ims = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "ims", "ims");
        domainMap.addBusinessDomain(domain_ims);

        BusinessDomain domain_wms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "wms", "wms");
        domainMap.addBusinessDomain(domain_wms);

        UpstreamDownstreamRelationship upstreamDownstreamRelationship = new UpstreamDownstreamRelationship();
        upstreamDownstreamRelationship.setUpstream(new OpenHostService(domain_ims));
        upstreamDownstreamRelationship.setDownstream(new Conformist(domain_wms));
        domainMap.addBusinessDomainRelationship(upstreamDownstreamRelationship);

        System.out.println(domainMap);
    }

    @Test
    public void test_create_UD_OHS_ACL() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_tms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "tms", "tms");
        domainMap.addBusinessDomain(domain_tms);

        BusinessDomain domain_lc = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "lc", "lc");
        domainMap.addBusinessDomain(domain_lc);

        UpstreamDownstreamRelationship upstreamDownstreamRelationship = new UpstreamDownstreamRelationship();
        upstreamDownstreamRelationship.setUpstream(new OpenHostService(domain_tms));
        upstreamDownstreamRelationship.setDownstream(new AnticorruptionLayer(domain_lc));
        domainMap.addBusinessDomainRelationship(upstreamDownstreamRelationship);

        System.out.println(domainMap);
    }

    @Test
    public void test_create_UD_PL_CF() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_ims = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "ims", "ims");
        domainMap.addBusinessDomain(domain_ims);

        BusinessDomain domain_wms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "wms", "wms");
        domainMap.addBusinessDomain(domain_wms);

        UpstreamDownstreamRelationship upstreamDownstreamRelationship = new UpstreamDownstreamRelationship();
        upstreamDownstreamRelationship.setUpstream(new PublishedLanguage(domain_ims));
        upstreamDownstreamRelationship.setDownstream(new Conformist(domain_wms));
        domainMap.addBusinessDomainRelationship(upstreamDownstreamRelationship);

        System.out.println(domainMap);
    }

    @Test
    public void test_create_UD_PL_ACL() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_tms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "tms", "tms");
        domainMap.addBusinessDomain(domain_tms);

        BusinessDomain domain_lc = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "lc", "lc");
        domainMap.addBusinessDomain(domain_lc);

        UpstreamDownstreamRelationship upstreamDownstreamRelationship = new UpstreamDownstreamRelationship();
        upstreamDownstreamRelationship.setUpstream(new PublishedLanguage(domain_tms));
        upstreamDownstreamRelationship.setDownstream(new AnticorruptionLayer(domain_lc));
        domainMap.addBusinessDomainRelationship(upstreamDownstreamRelationship);

        System.out.println(domainMap);
    }

    @Test
    public void test_create_UD_CS() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_tms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "tms", "tms");
        domainMap.addBusinessDomain(domain_tms);

        BusinessDomain domain_lc = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "lc", "lc");
        domainMap.addBusinessDomain(domain_lc);

        CustomerSupplierRelationship customerSupplierRelationship = new CustomerSupplierRelationship();
        customerSupplierRelationship.setCustomer(new CustomerRole(domain_lc));
        customerSupplierRelationship.setSupplier(new SupplierRole(domain_tms));
        domainMap.addBusinessDomainRelationship(customerSupplierRelationship);

        System.out.println(domainMap);
    }
}
