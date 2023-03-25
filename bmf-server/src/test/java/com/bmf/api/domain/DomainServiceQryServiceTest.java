package com.bmf.api.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.dto.DomainServiceQryReqDTO;
import com.bmf.api.domain.dto.DomainServiceRespDTO;
import com.bmf.api.domain.qry.DomainServiceQryService;
import com.bmf.base.tactics.service.DomainService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessApiTest {

    @Autowired
    private DomainServiceQryService domainServiceQryService;

    @Test
    public void testDomainServiceQueryOne() {
        DomainServiceQryReqDTO domainServiceQryReqDTO = new DomainServiceQryReqDTO();
        DomainService domainService = new DomainService();
        domainService.setDomainCode(101);
        domainService.setServiceCode(10001);
        domainServiceQryReqDTO.setDomainService(domainService);
        domainServiceQryReqDTO.setIncludeAttr(true);
        Result<DomainServiceRespDTO> result = domainServiceQryService.queryOne(domainServiceQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData().getServiceAttrList().size() == 3);
    }
}

