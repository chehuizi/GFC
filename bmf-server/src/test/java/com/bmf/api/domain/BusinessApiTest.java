package com.bmf.api.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DomainServiceCmdService;
import com.bmf.api.domain.dto.DomainServiceCmdReqDTO;
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
public class BusinessApiTest {

    @Autowired
    private DomainServiceCmdService domainServiceCmdService;

    @Test
    public void testAddServiceAttr() {
        DomainServiceCmdReqDTO serviceReqDTO = new DomainServiceCmdReqDTO();
        DomainService domainService = new DomainService();
        domainService.setServiceCode(10003);
        DomainServiceAttr serviceAttr = new DomainServiceAttr();
        serviceAttr.setServiceCode(10003);
        serviceAttr.setAttrName("inventoryWhSn");
        serviceAttr.setAttrType(AttrTypeEnum.STRING.getType());
        serviceAttr.setAttrDesc("盘点仓库（仓库编码）");
        serviceReqDTO.setServiceAttr(serviceAttr);
        serviceReqDTO.setDomainService(domainService);
        Result<Boolean> result = domainServiceCmdService.addServiceAttr(serviceReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void testDelServiceAttr() {
        DomainServiceCmdReqDTO serviceReqDTO = new DomainServiceCmdReqDTO();
        DomainServiceAttr serviceAttr = new DomainServiceAttr();
        serviceAttr.setServiceCode(100002);
        serviceAttr.setAttrName("outboundType");
        serviceReqDTO.setServiceAttr(serviceAttr);
        Result<Boolean> result = domainServiceCmdService.delServiceAttr(serviceReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }
}

