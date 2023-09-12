package com.bmf.api.business;

import com.alibaba.fastjson.JSON;
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
        business.setBusinessCode(102);
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
        BusinessDomain domain4 = new BusinessDomain();
        domain4.setDomainAlias("wms");
        domain4.setDomainName("仓储域");
        domain4.setDomainType(BusinessDomainTypeEnum.CORE.getType());
        domain4.setDomainLevel(BusinessDomainLevelEnum.THREE.getValue());
        domain4.setDomainPosition("{\"x\": 500, \"y\": 400}");
        businessDomainList.add(domain4);
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
        BusinessDomainRelationship relationship3 = new UpstreamDownstreamRelationship();
        relationship3.setRoleA(new OpenHostServiceRole(domain1));
        relationship3.setRoleB(new ConformistRole(domain4));
        relationshipList.add(relationship3);
        BusinessDomainRelationship relationship4 = new Partnership();
        relationship4.setRoleA(new PartnerRole(domain2));
        relationship4.setRoleB(new PartnerRole(domain3));
        relationshipList.add(relationship4);
        BusinessDomainRelationship relationship5 = new Partnership();
        relationship5.setRoleA(new PartnerRole(domain2));
        relationship5.setRoleB(new PartnerRole(domain4));
        relationshipList.add(relationship5);
        businessCmdReqDTO.setRelationshipList(relationshipList);
        Result<Boolean> result = businessCmdService.saveStrategyDesign(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_business_save_strategy_design_2() {
        String str = "{\"business\":{\"businessCode\":102},\"domainList\":[{\"domainCode\":\"111\",\"domainName\":\"库存域\",\"domainAlias\":\"ims\",\"domainType\":\"core\",\"domainTypeDesc\":\"核心域\",\"domainPosition\":\"{\\\"x\\\":254,\\\"y\\\":38}\"},{\"domainCode\":\"112\",\"domainName\":\"履约域1\",\"domainAlias\":\"ofc\",\"domainType\":\"core\",\"domainTypeDesc\":\"核心域\",\"domainPosition\":\"{\\\"x\\\":586,\\\"y\\\":152}\"},{\"domainCode\":\"113\",\"domainName\":\"物流域\",\"domainAlias\":\"tms\",\"domainType\":\"core\",\"domainTypeDesc\":\"核心域\",\"domainPosition\":\"{\\\"x\\\":153,\\\"y\\\":261}\"},{\"domainCode\":\"114\",\"domainName\":\"仓储域\",\"domainAlias\":\"wms\",\"domainType\":\"core\",\"domainTypeDesc\":\"核心域\",\"domainPosition\":\"{\\\"x\\\":402,\\\"y\\\":348}\"},{\"domainCode\":\"1\",\"domainName\":\"供应商\",\"domainAlias\":\"supplier\",\"domainType\":\"core\",\"domainPosition\":\"{\\\"x\\\":584,\\\"y\\\":385}\"}],\"relationshipList\":[{\"relationship\":\"upstream-downstream\",\"roleA\":{\"domain\":{\"domainCode\":\"111\"},\"role\":\"OHS\"},\"roleB\":{\"domain\":{\"domainCode\":\"112\"},\"role\":\"CF\"}},{\"relationship\":\"upstream-downstream\",\"roleA\":{\"domain\":{\"domainCode\":\"111\"},\"role\":\"OHS\"},\"roleB\":{\"domain\":{\"domainCode\":\"113\"},\"role\":\"CF\"}},{\"relationship\":\"upstream-downstream\",\"roleA\":{\"domain\":{\"domainCode\":\"111\"},\"role\":\"OHS\"},\"roleB\":{\"domain\":{\"domainCode\":\"114\"},\"role\":\"CF\"}},{\"relationship\":\"partnership\",\"roleA\":{\"domain\":{\"domainCode\":\"112\"},\"role\":\"partner\"},\"roleB\":{\"domain\":{\"domainCode\":\"113\"},\"role\":\"partner\"}},{\"relationship\":\"partnership\",\"roleA\":{\"domain\":{\"domainCode\":\"112\"},\"role\":\"partner\"},\"roleB\":{\"domain\":{\"domainCode\":\"114\"},\"role\":\"partner\"}},{\"relationship\":\"partnership\",\"roleA\":{\"domain\":{\"domainCode\":\"114\"},\"role\":\"partner\"},\"roleB\":{\"domain\":{\"domainCode\":\"1\", \"domainAlias\":\"supplier\"},\"role\":\"partner\"}}]}";
        BusinessCmdReqDTO businessCmdReqDTO = JSON.parseObject(str, BusinessCmdReqDTO.class);
        Result<Boolean> result = businessCmdService.saveStrategyDesign(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}