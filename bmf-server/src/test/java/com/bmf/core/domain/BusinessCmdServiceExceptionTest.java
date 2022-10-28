package com.bmf.core.domain;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessCmdService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.base.Business;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessCmdServiceExceptionTest {

    @Autowired
    private BusinessCmdService businessCmdService;

    @Test
    public void test_business_add_domain_exp_1() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(5);
        business.setBusinessName("chz");
        businessReqDTO.setBusiness(business);
        Result<Boolean> result = businessCmdService.addDomain(businessReqDTO);
        System.out.println(result);
    }
}

