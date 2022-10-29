package com.bmf.core.domain;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.api.business.BusinessRespDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.BusinessDomainTypeEnum;
import com.bmf.base.strategy.role.partner.PartnerRole;
import com.bmf.base.strategy.symmetric.Partnership;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessCmdServiceTest {

    @Autowired
    private BusinessCmdService businessCmdService;

    @Test
    public void test_business_create() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(1011);
        business.setBusinessName("chz");
        businessReqDTO.setBusiness(business);
        Result<Boolean> result = businessCmdService.create(businessReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_business_del_domain() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(1011);
        business.setBusinessName("chz");
        businessReqDTO.setBusiness(business);
        Result<Boolean> result = businessCmdService.delDomain(businessReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_business_build_domain_relation() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(11);
        business.setBusinessName("test_business_1");
        businessReqDTO.setBusiness(business);
        Partnership partnership = new Partnership();
        partnership.setBusinessCode(11);
        PartnerRole roleA = new PartnerRole();
        roleA.setDomain(new BusinessDomain(1, "test_domain_1", BusinessDomainTypeEnum.CORE.getType(), 1));
        partnership.setRoleA(roleA);
        PartnerRole roleB = new PartnerRole();
        roleB.setDomain(new BusinessDomain(2, "test_domain_2", BusinessDomainTypeEnum.CORE.getType(), 1));
        partnership.setRoleB(roleB);
        businessReqDTO.setRelationship(partnership);
        Result<Boolean> result = businessCmdService.buildDomainRelation(businessReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_business_remove_domain_relation() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(11);
        business.setBusinessName("test_business_1");
        businessReqDTO.setBusiness(business);
        Partnership partnership = new Partnership();
        partnership.setBusinessCode(11);
        PartnerRole roleA = new PartnerRole();
        roleA.setDomain(new BusinessDomain(1, "test_domain_1", BusinessDomainTypeEnum.CORE.getType(), 1));
        partnership.setRoleA(roleA);
        PartnerRole roleB = new PartnerRole();
        roleB.setDomain(new BusinessDomain(2, "test_domain_2", BusinessDomainTypeEnum.CORE.getType(), 1));
        partnership.setRoleB(roleB);
        businessReqDTO.setRelationship(partnership);
        Result<Boolean> result = businessCmdService.removeDomainRelation(businessReqDTO);
        System.out.println(result);
    }
}

