package com.bmf.api.business;

import com.bmf.common.api.Result;
import com.bmf.design.api.business.BusinessQryService;
import com.bmf.design.api.business.dto.BusinessQryReqDTO;
import com.bmf.design.api.business.dto.BusinessRespDTO;
import com.bmf.design.model.Business;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessQryServiceTest {

    @Autowired
    private BusinessQryService businessQryService;

    @Test
    public void test_business_query_one_1() {
        BusinessQryReqDTO businessQryReqDTO = new BusinessQryReqDTO();
        Business business = new Business();
        business.setBusinessCode(101);
        businessQryReqDTO.setBusiness(business);
        Result<BusinessRespDTO> result = businessQryService.queryOne(businessQryReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_business_query_one_2() {
        BusinessQryReqDTO businessQryReqDTO = new BusinessQryReqDTO();
        Business business = new Business();
        business.setBusinessCode(10003);
        businessQryReqDTO.setBusiness(business);
        businessQryReqDTO.setIncludeDomain(true);
        Result<BusinessRespDTO> result = businessQryService.queryOne(businessQryReqDTO);
        System.out.println(result);
    }

    @Test
    public void test_business_query_one_3() {
        BusinessQryReqDTO businessQryReqDTO = new BusinessQryReqDTO();
        Business business = new Business();
        business.setBusinessCode(10);
        businessQryReqDTO.setBusiness(business);
        businessQryReqDTO.setIncludeDomain(true);
        businessQryReqDTO.setIncludeDomainRelation(true);
        Result<BusinessRespDTO> result = businessQryService.queryOne(businessQryReqDTO);
        System.out.println(result);
    }
}

