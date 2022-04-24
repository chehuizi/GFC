package com.bmf.domain.base;

import com.bmf.domain.base.enums.BusinessDomainLevelEnum;
import com.bmf.domain.base.enums.BusinessDomainTypeEnum;
import com.bmf.domain.base.enums.RelationshipEnum;
import com.bmf.domain.base.strategy.asymmetric.UpstreamDownstreamRelationship;
import com.bmf.domain.base.strategy.inclusion.InclusionRelationship;
import com.bmf.domain.base.strategy.role.downstream.Conformist;
import com.bmf.domain.base.strategy.role.inclusion.KernelRole;
import com.bmf.domain.base.strategy.role.inclusion.ShellRole;
import com.bmf.domain.base.strategy.role.upstream.OpenHostService;
import com.bmf.domain.base.strategy.symmetric.Partnership;
import com.bmf.domain.base.strategy.symmetric.SharedKernel;
import org.junit.Test;

public class BusinessDomainMap4InclusionTest {

    @Test
    public void test_create_inclusion() {
        BusinessDomainMap domainMap = new BusinessDomainMap();
        BusinessDomain domain_scm = new BusinessDomain(BusinessDomainLevelEnum.ONE.getValue(), BusinessDomainTypeEnum.CORE.getType(), "scm");
        domainMap.addBusinessDomain(domain_scm);

        BusinessDomain domain_ofc = new BusinessDomain(BusinessDomainLevelEnum.TWO.getValue(), BusinessDomainTypeEnum.CORE.getType(), "ofc");
        domainMap.addBusinessDomain(domain_ofc);

        InclusionRelationship inclusionRelationship = new InclusionRelationship();
        inclusionRelationship.setDomainA(domain_scm);
        inclusionRelationship.setDomainB(domain_ofc);
        inclusionRelationship.setShell(new ShellRole(domain_scm));
        inclusionRelationship.setKernel(new KernelRole(domain_ofc));
        domainMap.addBusinessDomainRelationship(inclusionRelationship);

        System.out.println(domainMap);
    }
}
