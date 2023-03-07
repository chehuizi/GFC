package com.bmf.api.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DomainEventCmdService;
import com.bmf.api.domain.dto.DomainEventReqDTO;
import com.bmf.base.enums.AttrTypeEnum;
import com.bmf.base.tactics.event.DomainEvent;
import com.bmf.base.tactics.event.DomainEventAttr;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainEventCmdServiceTest {

    @Autowired
    private DomainEventCmdService domainEventCmdService;

    @Test
    public void testAddEventAttr() {
        DomainEventReqDTO domainEventReqDTO = new DomainEventReqDTO();
        DomainEvent domainEvent = new DomainEvent();
        domainEvent.setEventCode(104);
        domainEventReqDTO.setDomainEvent(domainEvent);
        DomainEventAttr domainEventAttr = new DomainEventAttr();
        domainEventAttr.setEventCode(104);
        domainEventAttr.setAttrName("outboundTime");
        domainEventAttr.setAttrType(AttrTypeEnum.TIMESTAMP.getType());
        domainEventAttr.setAttrDesc("出库时间");
        domainEventReqDTO.setEventAttr(domainEventAttr);
        Result<Boolean> result = domainEventCmdService.addEventAttr(domainEventReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void testDelEventAttr() {
        DomainEventReqDTO domainEventReqDTO = new DomainEventReqDTO();
        DomainEventAttr domainEventAttr = new DomainEventAttr();
        domainEventAttr.setEventCode(104);
        domainEventAttr.setAttrName("outboundTime");
        domainEventReqDTO.setEventAttr(domainEventAttr);
        Result<Boolean> result = domainEventCmdService.delEventAttr(domainEventReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }
}
