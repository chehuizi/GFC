package com.bmf.api;

import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.dto.BusinessReqDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
import com.bmf.common.enums.BizCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessCmdServiceExceptionTest {

    @Autowired
    private BusinessCmdService businessCmdService;

    @Test
    public void test_business_create_exp_80001_1() {
        Result<Boolean> result = businessCmdService.create(null);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_business_create_exp_80001_2() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        businessReqDTO.setBusiness(null);
        Result<Boolean> result = businessCmdService.create(businessReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_business_create_exp_100003() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(10);
        business.setBusinessName("chz_test");
        businessReqDTO.setBusiness(business);
        Result<Boolean> result = businessCmdService.create(businessReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.BUSINESS_IS_EXISTED.getCode() == result.getCode());
    }

    @Test
    public void test_business_add_domain_exp_80001_1() {
        Result<Boolean> result = businessCmdService.addDomain(null);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_business_add_domain_exp_80001_2() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        businessReqDTO.setBusiness(null);
        Result<Boolean> result = businessCmdService.addDomain(businessReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_business_add_domain_exp_80001_3() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        businessReqDTO.setBusiness(business);
        Result<Boolean> result = businessCmdService.addDomain(businessReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_business_add_domain_exp_100001() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(11);
        businessReqDTO.setBusiness(business);
        BusinessDomain domain = new BusinessDomain();
        domain.setDomainCode(10);
        businessReqDTO.setDomain(domain);
        Result<Boolean> result = businessCmdService.addDomain(businessReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.BUSINESS_NOT_EXIST.getCode() == result.getCode());
    }

    @Test
    public void test_business_del_domain_exp_80001_1() {
        Result<Boolean> result = businessCmdService.delDomain(null);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }
}

