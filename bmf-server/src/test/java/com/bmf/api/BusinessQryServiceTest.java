package com.bmf.api;

import com.bmf.api.business.BusinessQryService;
import com.bmf.api.business.dto.BusinessQryReqDTO;
import com.bmf.api.business.dto.BusinessReqDTO;
import com.bmf.api.business.dto.BusinessRespDTO;
import com.bmf.base.Business;
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
    public void test_business_query_one() {
        BusinessQryReqDTO businessQryReqDTO = new BusinessQryReqDTO();
        Business business = new Business();
        business.setBusinessCode(10);
        businessQryReqDTO.setBusiness(business);
        businessQryReqDTO.setIncludeDomain(true);
        Result<BusinessRespDTO> result = businessQryService.queryOne(businessQryReqDTO);
        System.out.println(result);
    }

}

