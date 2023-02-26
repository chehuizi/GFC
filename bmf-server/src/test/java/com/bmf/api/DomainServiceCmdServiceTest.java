package com.bmf.api;

import com.bmf.api.domain.cmd.DomainServiceCmdService;
import com.bmf.api.domain.dto.DomainServiceReqDTO;
import com.bmf.base.enums.AttrTypeEnum;
import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.service.DomainServiceAttr;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainServiceCmdServiceTest {

    @Autowired
    private DomainServiceCmdService domainServiceCmdService;

    @Test
    public void testAddServiceAttr() {
        DomainServiceReqDTO serviceReqDTO = new DomainServiceReqDTO();
        DomainService domainService = new DomainService();
        domainService.setServiceCode(100002);
        DomainServiceAttr serviceAttr = new DomainServiceAttr();
        serviceAttr.setServiceCode(100002);
        serviceAttr.setAttrName("outboundType");
        serviceAttr.setAttrType(AttrTypeEnum.STRING.getType());
        serviceAttr.setAttrDesc("出库方式（扫码、RFID）");
        serviceReqDTO.setServiceAttr(serviceAttr);
        serviceReqDTO.setDomainService(domainService);
        Result<Boolean> result = domainServiceCmdService.addServiceAttr(serviceReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void testDelServiceAttr() {
        DomainServiceReqDTO serviceReqDTO = new DomainServiceReqDTO();
        DomainServiceAttr serviceAttr = new DomainServiceAttr();
        serviceAttr.setServiceCode(100002);
        serviceAttr.setAttrName("outboundType");
        serviceReqDTO.setServiceAttr(serviceAttr);
        Result<Boolean> result = domainServiceCmdService.delServiceAttr(serviceReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }
}

