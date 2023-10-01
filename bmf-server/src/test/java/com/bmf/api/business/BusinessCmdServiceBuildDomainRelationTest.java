package com.bmf.api.business;

import com.bmf.design.api.Result;
import com.bmf.design.api.business.BusinessCmdService;
import com.bmf.design.api.business.dto.BusinessCmdReqDTO;
import com.bmf.design.api.domain.qry.DomainQryService;
import com.bmf.design.api.domain.dto.DomainQryReqDTO;
import com.bmf.design.api.domain.dto.DomainRespDTO;
import com.bmf.design.base.Business;
import com.bmf.design.base.Domain;
import com.bmf.design.base.strategy.asymmetric.UpstreamDownstreamRelationship;
import com.bmf.design.base.strategy.role.downstream.ConformistRole;
import com.bmf.design.base.strategy.role.partner.PartnerRole;
import com.bmf.design.base.strategy.role.upstream.OpenHostServiceRole;
import com.bmf.design.base.strategy.symmetric.Partnership;
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
        UpstreamDownstreamRelationship upstreamDownstreamRelationship = new UpstreamDownstreamRelationship();
        upstreamDownstreamRelationship.setBusinessCode(10);
        OpenHostServiceRole ohs = new OpenHostServiceRole();
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        Domain domain = new Domain();
        domain.setDomainCode(50);
        domainQryReqDTO.setDomain(domain);
        Result<DomainRespDTO> result1 = domainQryService.queryOne(domainQryReqDTO);
        ohs.setDomain(result1.getData().getDomain());
        upstreamDownstreamRelationship.setRoleA(ohs);
        ConformistRole cf = new ConformistRole();
        domain.setDomainCode(10);
        Result<DomainRespDTO> result2 = domainQryService.queryOne(domainQryReqDTO);
        cf.setDomain(result2.getData().getDomain());
        upstreamDownstreamRelationship.setRoleB(cf);
        businessCmdReqDTO.setRelationship(upstreamDownstreamRelationship);
        Result<Boolean> result = businessCmdService.buildDomainRelation(businessCmdReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_business_build_domain_relation_ps() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(101);
        businessCmdReqDTO.setBusiness(business);
        Partnership partnership = new Partnership();
        partnership.setBusinessCode(101);
        PartnerRole partnerA = new PartnerRole();
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        Domain domain = new Domain();
        domain.setDomainCode(103);
        domainQryReqDTO.setDomain(domain);
        Result<DomainRespDTO> result1 = domainQryService.queryOne(domainQryReqDTO);
        partnerA.setDomain(result1.getData().getDomain());
        partnership.setRoleA(partnerA);
        PartnerRole partnerB = new PartnerRole();
        domain.setDomainCode(104);
        Result<DomainRespDTO> result2 = domainQryService.queryOne(domainQryReqDTO);
        partnerB.setDomain(result2.getData().getDomain());
        partnership.setRoleB(partnerB);
        businessCmdReqDTO.setRelationship(partnership);
        Result<Boolean> result = businessCmdService.buildDomainRelation(businessCmdReqDTO);
        System.out.println(result);
    }

}

