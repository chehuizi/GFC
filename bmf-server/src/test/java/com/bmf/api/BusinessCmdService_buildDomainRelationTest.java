package com.bmf.api;

import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.dto.BusinessReqDTO;
import com.bmf.api.domain.DomainQryService;
import com.bmf.api.domain.DomainReqDTO;
import com.bmf.api.domain.DomainRespDTO;
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
public class BusinessCmdService_buildDomainRelationTest {

    @Autowired
    private BusinessCmdService businessCmdService;
    @Autowired
    private DomainQryService domainQryService;

    @Test
    public void test_business_build_domain_relation_cf() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(10);
        businessReqDTO.setBusiness(business);
        UpstreamDownstreamRelationship<OpenHostServiceRole, ConformistRole> upstreamDownstreamRelationship = new UpstreamDownstreamRelationship();
        upstreamDownstreamRelationship.setBusinessCode(10);
        OpenHostServiceRole ohs = new OpenHostServiceRole();
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain domain = new BusinessDomain();
        domain.setDomainCode(50);
        domainReqDTO.setBusinessDomain(domain);
        Result<DomainRespDTO> result1 = domainQryService.queryOne(domainReqDTO);
        ohs.setDomain(result1.getData().getBusinessDomain());
        upstreamDownstreamRelationship.setRoleA(ohs);
        ConformistRole cf = new ConformistRole();
        domain.setDomainCode(10);
        Result<DomainRespDTO> result2 = domainQryService.queryOne(domainReqDTO);
        cf.setDomain(result2.getData().getBusinessDomain());
        upstreamDownstreamRelationship.setRoleB(cf);
        businessReqDTO.setRelationship(upstreamDownstreamRelationship);
        Result<Boolean> result = businessCmdService.buildDomainRelation(businessReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_business_build_domain_relation_ps() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(10);
        businessReqDTO.setBusiness(business);
        Partnership partnership = new Partnership();
        partnership.setBusinessCode(10);
        PartnerRole partnerA = new PartnerRole();
        DomainReqDTO domainReqDTO = new DomainReqDTO();
        BusinessDomain domain = new BusinessDomain();
        domain.setDomainCode(10);
        domainReqDTO.setBusinessDomain(domain);
        Result<DomainRespDTO> result1 = domainQryService.queryOne(domainReqDTO);
        partnerA.setDomain(result1.getData().getBusinessDomain());
        partnership.setRoleA(partnerA);
        PartnerRole partnerB = new PartnerRole();
        domain.setDomainCode(20);
        Result<DomainRespDTO> result2 = domainQryService.queryOne(domainReqDTO);
        partnerB.setDomain(result2.getData().getBusinessDomain());
        partnership.setRoleB(partnerB);
        businessReqDTO.setRelationship(partnership);
        Result<Boolean> result = businessCmdService.buildDomainRelation(businessReqDTO);
        System.out.println(result);
    }

}

