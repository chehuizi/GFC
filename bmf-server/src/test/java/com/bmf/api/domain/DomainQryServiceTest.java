package com.bmf.api.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.qry.DomainQryService;
import com.bmf.api.domain.dto.DomainQryReqDTO;
import com.bmf.api.domain.dto.DomainRespDTO;
import com.bmf.base.Domain;
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
        Domain domain = new Domain();
        domain.setDomainCode(10);
        domainQryReqDTO.setDomain(domain);
        Result<DomainRespDTO> result = domainQryService.queryOne(domainQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(10 == result.getData().getDomain().getDomainCode());
    }

    @Test
    public void test_domain_query_one_2() {
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        Domain domain = new Domain();
        domain.setDomainAlias("wms");
        domainQryReqDTO.setDomain(domain);
        Result<DomainRespDTO> result = domainQryService.queryOne(domainQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(10 == result.getData().getDomain().getDomainCode());
    }

    @Test
    public void test_domain_query_one_3() {
        DomainQryReqDTO domainQryReqDTO = new DomainQryReqDTO();
        Domain domain = new Domain();
        domain.setDomainCode(103);
        domainQryReqDTO.setDomain(domain);
        domainQryReqDTO.setIncludeEntity(true);
        domainQryReqDTO.setIncludeService(true);
        domainQryReqDTO.setIncludeEvent(true);
        Result<DomainRespDTO> result = domainQryService.queryOne(domainQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(1 == result.getData().getDomain().getDomainEntityList().size()
            && 1 == result.getData().getDomain().getDomainServiceList().size()
            && 1 == result.getData().getDomain().getDomainEventList().size());
    }
}

