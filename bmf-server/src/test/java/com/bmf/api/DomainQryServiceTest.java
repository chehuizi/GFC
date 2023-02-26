package com.bmf.api;

import com.bmf.api.domain.DomainQryService;
import com.bmf.api.domain.dto.DomainQryReqDTO;
import com.bmf.api.domain.dto.DomainRespDTO;
import com.bmf.base.BusinessDomain;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainQryServiceTest {

    @Autowired
    private DomainQryService domainQryService;

    @Test
    public void test_domain_query_one_1() {
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(10);
        domainQryReqDTO.setBusinessDomain(businessDomain);
        Result<DomainRespDTO> result = domainQryService.queryOne(domainQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(10 == result.getData().getBusinessDomain().getDomainCode());
    }

    @Test
    public void test_domain_query_one_2() {
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainAlias("wms");
        domainQryReqDTO.setBusinessDomain(businessDomain);
        Result<DomainRespDTO> result = domainQryService.queryOne(domainQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(10 == result.getData().getBusinessDomain().getDomainCode());
    }

}

