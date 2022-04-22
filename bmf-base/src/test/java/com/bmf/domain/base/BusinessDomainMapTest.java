package com.bmf.domain.base;

import com.bmf.domain.base.enums.BusinessDomainLevelEnum;
import com.bmf.domain.base.enums.BusinessDomainTypeEnum;
import com.bmf.domain.base.enums.RelationshipEnum;
import com.bmf.domain.base.strategy.symmetric.Partnership;
import org.junit.Test;

public class BusinessDomainMapTest {

    @Test
    public void testBusinessDomainMapCreate() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_1 = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "wms");
        domainMap.addBusinessDomain(domain_1);

        BusinessDomain domain_2 = new BusinessDomain(BusinessDomainLevelEnum.Three.getValue(), BusinessDomainTypeEnum.CORE.getType(), "tms");
        domainMap.addBusinessDomain(domain_2);

        Partnership partnership = new Partnership();
        partnership.setRelationship(RelationshipEnum.PS.getType());
        partnership.setDomainA(domain_1);
        partnership.setDomainB(domain_2);
        domainMap.addBusinessDomainRelationship(partnership);

        System.out.println(domainMap);
    }

}
