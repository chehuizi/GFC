package com.bmf.api.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DomainEventCmdService;
import com.bmf.api.domain.dto.DomainEventCmdReqDTO;
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
        DomainEventCmdReqDTO domainEventCmdReqDTO = new DomainEventCmdReqDTO();
        DomainEvent domainEvent = new DomainEvent();
        domainEvent.setEventCode(10003);
        domainEventCmdReqDTO.setDomainEvent(domainEvent);
        DomainEventAttr domainEventAttr = new DomainEventAttr();
        domainEventAttr.setEventCode(10003);
        domainEventAttr.setAttrName("inventoryOrderNo");
        domainEventAttr.setAttrType(AttrTypeEnum.STRING.getType());
        domainEventAttr.setAttrDesc("盘点单号");
        domainEventCmdReqDTO.setEventAttr(domainEventAttr);
        Result<Boolean> result = domainEventCmdService.addEventAttr(domainEventCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void testDelEventAttr() {
        DomainEventCmdReqDTO domainEventCmdReqDTO = new DomainEventCmdReqDTO();
        DomainEventAttr domainEventAttr = new DomainEventAttr();
        domainEventAttr.setEventCode(104);
        domainEventAttr.setAttrName("outboundTime");
        domainEventCmdReqDTO.setEventAttr(domainEventAttr);
        Result<Boolean> result = domainEventCmdService.delEventAttr(domainEventCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }
}
