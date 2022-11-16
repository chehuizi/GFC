package com.bmf.base;

import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.base.enums.RelationshipEnum;
import com.bmf.base.strategy.symmetric.Partnership;
import com.bmf.base.strategy.symmetric.SharedKernel;
import org.junit.Test;

public class BusinessDomainMap4SymmetricTest {

    @Test
    public void test_create_PS() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_wms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "wms", "wms");
        domainMap.addBusinessDomain(domain_wms);

        BusinessDomain domain_tms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "tms", "tms");
        domainMap.addBusinessDomain(domain_tms);

        Partnership partnership = new Partnership();
        partnership.setRelationship(RelationshipEnum.PS.getType());
        domainMap.addBusinessDomainRelationship(partnership);

        System.out.println(domainMap);
    }

    @Test
    public void test_create_SK() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_oms = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "oms", "oms");
        domainMap.addBusinessDomain(domain_oms);

        BusinessDomain domain_ofc = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "ofc", "ofc");
        domainMap.addBusinessDomain(domain_ofc);

        SharedKernel sharedKernel = new SharedKernel();
        sharedKernel.setRelationship(RelationshipEnum.SK.getType());
        domainMap.addBusinessDomainRelationship(sharedKernel);

        System.out.println(domainMap);
    }
}
