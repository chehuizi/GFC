package com.bmf.api.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DomainEventCmdService;
import com.bmf.api.domain.dto.DomainEventQryReqDTO;
import com.bmf.api.domain.dto.DomainEventRespDTO;
import com.bmf.api.domain.qry.DomainEventQryService;
import com.bmf.base.tactics.event.DomainEvent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainEventQryServiceTest {

    @Autowired
    private DomainEventQryService domainEventQryService;

    @Test
    public void testDomainEventQueryOne() {
        DomainEventQryReqDTO domainEventQryReqDTO = new DomainEventQryReqDTO();
        DomainEvent domainEvent = new DomainEvent();
        domainEvent.setDomainCode(101);
        domainEvent.setEventCode(10001);
        domainEventQryReqDTO.setDomainEvent(domainEvent);
        domainEventQryReqDTO.setIncludeAttr(true);
        Result<DomainEventRespDTO> result = domainEventQryService.queryOne(domainEventQryReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData().getEventAttrList().size() == 1);
    }

}
