package com.bmf.api;

import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.api.domain.DomainQryService;
import com.bmf.api.domain.dto.DomainQryReqDTO;
import com.bmf.api.domain.dto.DomainRespDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.strategy.asymmetric.UpstreamDownstreamRelationship;
import com.bmf.base.strategy.role.downstream.ConformistRole;
import com.bmf.base.strategy.role.partner.PartnerRole;
import com.bmf.base.strategy.role.upstream.OpenHostServiceRole;
import com.bmf.base.strategy.symmetric.Partnership;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessCmdServiceBuildDomainRelationTest {

    @Autowired
    private BusinessCmdService businessCmdService;
    @Autowired
    private DomainQryService domainQryService;

    @Test
    public void test_business_build_domain_relation_cf() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(10);
        businessCmdReqDTO.setBusiness(business);
        UpstreamDownstreamRelationship<OpenHostServiceRole, ConformistRole> upstreamDownstreamRelationship = new UpstreamDownstreamRelationship();
        upstreamDownstreamRelationship.setBusinessCode(10);
        OpenHostServiceRole ohs = new OpenHostServiceRole();
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        BusinessDomain domain = new BusinessDomain();
        domain.setDomainCode(50);
        domainQryReqDTO.setBusinessDomain(domain);
        Result<DomainRespDTO> result1 = domainQryService.queryOne(domainQryReqDTO);
        ohs.setDomain(result1.getData().getBusinessDomain());
        upstreamDownstreamRelationship.setRoleA(ohs);
        ConformistRole cf = new ConformistRole();
        domain.setDomainCode(10);
        Result<DomainRespDTO> result2 = domainQryService.queryOne(domainQryReqDTO);
        cf.setDomain(result2.getData().getBusinessDomain());
        upstreamDownstreamRelationship.setRoleB(cf);
        businessCmdReqDTO.setRelationship(upstreamDownstreamRelationship);
        Result<Boolean> result = businessCmdService.buildDomainRelation(businessCmdReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_business_build_domain_relation_ps() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(10);
        businessCmdReqDTO.setBusiness(business);
        Partnership partnership = new Partnership();
        partnership.setBusinessCode(10);
        PartnerRole partnerA = new PartnerRole();
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        BusinessDomain domain = new BusinessDomain();
        domain.setDomainCode(20);
        domainQryReqDTO.setBusinessDomain(domain);
        Result<DomainRespDTO> result1 = domainQryService.queryOne(domainQryReqDTO);
        partnerA.setDomain(result1.getData().getBusinessDomain());
        partnership.setRoleA(partnerA);
        PartnerRole partnerB = new PartnerRole();
        domain.setDomainCode(40);
        Result<DomainRespDTO> result2 = domainQryService.queryOne(domainQryReqDTO);
        partnerB.setDomain(result2.getData().getBusinessDomain());
        partnership.setRoleB(partnerB);
        businessCmdReqDTO.setRelationship(partnership);
        Result<Boolean> result = businessCmdService.buildDomainRelation(businessCmdReqDTO);
        System.out.println(result);
    }

}

