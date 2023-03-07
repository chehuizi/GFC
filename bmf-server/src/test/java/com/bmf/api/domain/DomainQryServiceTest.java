package com.bmf.api.domain;

import com.bmf.api.Result;
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

    @Test
    public void test_domain_query_one_3() {
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        BusinessDomain businessDomain = new BusinessDomain();
        businessDomain.setDomainCode(103);
        domainQryReqDTO.setBusinessDomain(businessDomain);
        domainQryReqDTO.setIncludeEntity(true);
        domainQryReqDTO.setIncludeService(true);
        domainQryReqDTO.setIncludeEvent(true);
        Result<DomainRespDTO> result = domainQryService.queryOne(domainQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(1 == result.getData().getBusinessDomain().getDomainEntityList().size()
            && 1 == result.getData().getBusinessDomain().getDomainServiceList().size()
            && 1 == result.getData().getBusinessDomain().getDomainEventList().size());
    }
}

