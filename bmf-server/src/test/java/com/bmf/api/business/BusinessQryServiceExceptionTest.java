package com.bmf.api.business;

import com.bmf.common.api.Result;
import com.bmf.design.api.business.BusinessQryService;
import com.bmf.design.api.business.dto.BusinessQryReqDTO;
import com.bmf.design.api.business.dto.BusinessRespDTO;
import com.bmf.design.model.Business;
import com.bmf.common.api.enums.BizCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessQryServiceExceptionTest {

    @Autowired
    private BusinessQryService businessQryService;

    @Test
    public void test_business_query_one_exp_80001_1() {
        Result<BusinessRespDTO> result = businessQryService.queryOne(null);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_business_query_one_exp_80001_2() {
        BusinessQryReqDTO businessQryReqDTO = new BusinessQryReqDTO();
        businessQryReqDTO.setBusiness(null);
        Result<BusinessRespDTO> result = businessQryService.queryOne(businessQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }

    @Test
    public void test_business_query_one_exp_80001_3() {
        BusinessQryReqDTO businessQryReqDTO = new BusinessQryReqDTO();
        Business business = new Business();
        businessQryReqDTO.setBusiness(business);
        Result<BusinessRespDTO> result = businessQryService.queryOne(businessQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(BizCodeEnum.PARAM_ERROR.getCode() == result.getCode());
    }
}

