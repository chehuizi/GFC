package com.bmf.api.business;

import com.bmf.api.Result;
import com.bmf.api.business.dto.BusinessCmdReqDTO;
import com.bmf.api.domain.qry.DomainQryService;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.base.enums.*;
import com.bmf.base.strategy.BusinessDomainRelationship;
import com.bmf.base.strategy.asymmetric.UpstreamDownstreamRelationship;
import com.bmf.base.strategy.role.downstream.ConformistRole;
import com.bmf.base.strategy.role.partner.PartnerRole;
import com.bmf.base.strategy.role.upstream.OpenHostServiceRole;
import com.bmf.base.strategy.symmetric.Partnership;
import com.bmf.common.enums.ResultCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessCmdStrategyDesignServiceTest {

    @Autowired
    private BusinessCmdService businessCmdService;
    @Autowired
    private DomainQryService domainQryService;

    @Test
    public void test_business_save_strategy_design_1() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(101);
        businessCmdReqDTO.setBusiness(business);
        List<BusinessDomain> businessDomainList = new ArrayList<>();
        BusinessDomain domain1 = new BusinessDomain();
        domain1.setDomainAlias("ims");
        domain1.setDomainName("库存域");
        domain1.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        domain1.setDomainLevel(BusinessDomainLevelEnum.THREE.getValue());
        domain1.setDomainPosition("{\"x\": 500, \"y\": 100}");
        businessDomainList.add(domain1);
        BusinessDomain domain2 = new BusinessDomain();
        domain2.setDomainAlias("ofc");
        domain2.setDomainName("履约域");
        domain2.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        domain2.setDomainLevel(BusinessDomainLevelEnum.THREE.getValue());
        domain2.setDomainPosition("{\"x\": 500, \"y\": 200}");
        businessDomainList.add(domain2);
        BusinessDomain domain3 = new BusinessDomain();
        domain3.setDomainAlias("tms");
        domain3.setDomainName("物流域");
        domain3.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        domain3.setDomainLevel(BusinessDomainLevelEnum.THREE.getValue());
        domain3.setDomainPosition("{\"x\": 500, \"y\": 300}");
        businessDomainList.add(domain3);
        businessCmdReqDTO.setDomainList(businessDomainList);
        List<BusinessDomainRelationship> relationshipList = new ArrayList<>();
        BusinessDomainRelationship relationship1 = new UpstreamDownstreamRelationship();
        relationship1.setRoleA(new OpenHostServiceRole(domain1));
        relationship1.setRoleB(new ConformistRole(domain2));
        relationshipList.add(relationship1);
        BusinessDomainRelationship relationship2 = new UpstreamDownstreamRelationship();
        relationship2.setRoleA(new OpenHostServiceRole(domain1));
        relationship2.setRoleB(new ConformistRole(domain3));
        relationshipList.add(relationship2);
        businessCmdReqDTO.setRelationshipList(relationshipList);
        Result<Boolean> result = businessCmdService.saveStrategyDesign(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_business_save_strategy_design_2() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(101);
        businessCmdReqDTO.setBusiness(business);
        List<BusinessDomain> businessDomainList = new ArrayList<>();
        BusinessDomain domain1 = new BusinessDomain();
        domain1.setDomainCode(104);
        domain1.setDomainAlias("ofc");
        domain1.setDomainName("履约域");
        domain1.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        domain1.setDomainLevel(BusinessDomainLevelEnum.THREE.getValue());
        domain1.setDomainPosition("{\"x\": 500, \"y\": 100}");
        businessDomainList.add(domain1);
        BusinessDomain domain2 = new BusinessDomain();
        domain2.setDomainCode(103);
        domain2.setDomainAlias("tms");
        domain2.setDomainName("物流域");
        domain2.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        domain2.setDomainLevel(BusinessDomainLevelEnum.THREE.getValue());
        domain2.setDomainPosition("{\"x\": 500, \"y\": 200}");
        businessDomainList.add(domain2);
        businessCmdReqDTO.setDomainList(businessDomainList);
        List<BusinessDomainRelationship> relationshipList = new ArrayList<>();
        BusinessDomainRelationship relationship1 = new Partnership();
        relationship1.setRelationship(RelationshipEnum.PS.getType());
        relationship1.setRoleA(new PartnerRole(domain1));
        relationship1.setRoleB(new PartnerRole(domain2));
        relationshipList.add(relationship1);
        businessCmdReqDTO.setRelationshipList(relationshipList);
        Result<Boolean> result = businessCmdService.saveStrategyDesign(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

}

