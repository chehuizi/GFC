package com.bmf.api.business;

import com.bmf.common.api.Result;
import com.bmf.design.api.business.BusinessCmdService;
import com.bmf.design.api.business.dto.BusinessCmdReqDTO;
import com.bmf.design.model.Business;
import com.bmf.design.model.Domain;
import com.bmf.common.api.enums.BizCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessCmdServiceDelDomainExceptionTest {

    @Autowired
    private BusinessCmdService businessCmdService;

    @Test
    public void test_business_del_domain_exp_80001_1() {
        Result<Boolean> result = businessCmdService.delDomain(null);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_business_del_domain_exp_100005_1() {
        BusinessCmdReqDTO businessCmdReqDTO = new BusinessCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(10);
        businessCmdReqDTO.setBusiness(business);
        Domain domain = new Domain();
        domain.setDomainCode(10);
        businessCmdReqDTO.setDomain(domain);
        Result<Boolean> result = businessCmdService.delDomain(businessCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.DOMAIN_HAS_RELATION.getCode() == result.getCode());
    }
}

