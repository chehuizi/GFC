package com.bmf.core.domain;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.base.Business;
import com.bmf.base.BusinessDomain;
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
    public void test_business_rel_domain_create() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(10);
        businessReqDTO.setBusiness(business);
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(10);
        businessReqDTO.setDomain(businessDomain);
        Result<Boolean> result = businessCmdService.addDomain(businessReqDTO);
        System.out.println(result);
    }
}

