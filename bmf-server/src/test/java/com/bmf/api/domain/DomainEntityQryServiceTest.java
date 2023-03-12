package com.bmf.api.domain;

import com.bmf.api.domain.dto.DomainEntityQryReqDTO;
import com.bmf.api.domain.qry.DomainEntityQryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainEntityQryServiceTest {

    @Autowired
    private DomainEntityQryService domainEntityQryService;

    @Test
    public void testAddEntityAttr() {
        DomainEntityQryReqDTO domainEntityQryReqDTO = new DomainEntityQryReqDTO();
        domainEntityQryReqDTO.setDomainEntity(null);
        domainEntityQryService.queryOne(domainEntityQryReqDTO);
    }
}

