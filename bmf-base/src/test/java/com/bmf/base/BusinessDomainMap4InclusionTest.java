package com.bmf.base;

import com.bmf.base.enums.BusinessDomainLevelEnum;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.base.strategy.inclusion.InclusionRelationship;
import com.bmf.base.strategy.role.inclusion.KernelRole;
import com.bmf.base.strategy.role.inclusion.ShellRole;
import org.junit.Test;

public class BusinessDomainMap4InclusionTest {

    @Test
    public void test_create_inclusion() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_scm = new BusinessDomain(BusinessDomainLevelEnum.ONE.getValue(), BusinessDomainTypeEnum.CORE.getType(), "scm", "scm");
        domainMap.addBusinessDomain(domain_scm);

        BusinessDomain domain_ofc = new BusinessDomain(BusinessDomainLevelEnum.TWO.getValue(), BusinessDomainTypeEnum.CORE.getType(), "ofc", "ofc");
        domainMap.addBusinessDomain(domain_ofc);

        InclusionRelationship inclusionRelationship = new InclusionRelationship();
        inclusionRelationship.setRoleA(new KernelRole(domain_ofc));
        inclusionRelationship.setRoleB(new ShellRole(domain_scm));
        domainMap.addBusinessDomainRelationship(inclusionRelationship);

        System.out.println(domainMap);
    }
}
