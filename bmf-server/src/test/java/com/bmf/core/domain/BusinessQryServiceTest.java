package com.bmf.core.domain;

import com.bmf.api.Result;
import com.bmf.api.business.BusinessQryService;
import com.bmf.api.business.BusinessReqDTO;
import com.bmf.api.business.BusinessRespDTO;
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
public class BusinessQryServiceTest {

    @Autowired
    private BusinessQryService businessQryService;

    @Test
    public void test_business_query_one() {
        BusinessReqDTO businessReqDTO = new BusinessReqDTO();
        Business business = new Business();
        business.setBusinessCode(1);
        businessReqDTO.setBusiness(business);
        Result<BusinessRespDTO> result = businessQryService.queryOne(businessReqDTO);
        System.out.println(result);
    }

}

