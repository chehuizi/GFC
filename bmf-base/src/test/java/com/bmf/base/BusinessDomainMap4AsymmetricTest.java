package com.bmf.base;

import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.base.strategy.asymmetric.CustomerSupplierRelationship;
import com.bmf.base.strategy.asymmetric.UpstreamDownstreamRelationship;
import com.bmf.base.strategy.role.downstream.CustomerRole;
import com.bmf.base.strategy.role.upstream.SupplierRole;
import com.bmf.base.strategy.role.downstream.AnticorruptionLayerRole;
import com.bmf.base.strategy.role.downstream.ConformistRole;
import com.bmf.base.strategy.role.upstream.OpenHostServiceRole;
import com.bmf.base.strategy.role.upstream.PublishedLanguageRole;
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
        upstreamDownstreamRelationship.setRoleA(new OpenHostServiceRole(domain_ims));
        upstreamDownstreamRelationship.setRoleB(new ConformistRole(domain_wms));
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
        upstreamDownstreamRelationship.setRoleA(new OpenHostServiceRole(domain_tms));
        upstreamDownstreamRelationship.setRoleB(new AnticorruptionLayerRole(domain_lc));
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
        upstreamDownstreamRelationship.setRoleA(new PublishedLanguageRole(domain_ims));
        upstreamDownstreamRelationship.setRoleB(new ConformistRole(domain_wms));
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
        upstreamDownstreamRelationship.setRoleA(new PublishedLanguageRole(domain_tms));
        upstreamDownstreamRelationship.setRoleB(new AnticorruptionLayerRole(domain_lc));
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
        customerSupplierRelationship.setRoleA(new SupplierRole(domain_tms));
        customerSupplierRelationship.setRoleB(new CustomerRole(domain_lc));
        domainMap.addBusinessDomainRelationship(customerSupplierRelationship);

        System.out.println(domainMap);
    }
}
