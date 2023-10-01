package com.bmf.api.domain;

import com.bmf.design.api.Result;
import com.bmf.design.api.domain.cmd.DomainEntityCmdService;
import com.bmf.design.api.domain.dto.DomainEntityCmdReqDTO;
import com.bmf.design.base.enums.AttrTypeEnum;
import com.bmf.design.base.tactics.entity.DomainEntity;
import com.bmf.design.base.tactics.entity.DomainEntityAttr;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainEntityCmdServiceTest {

    @Autowired
    private DomainEntityCmdService domainEntityCmdService;

    @Test
    public void testAddEntityAttr() {
        DomainEntityCmdReqDTO domainEntityCmdReqDTO = new DomainEntityCmdReqDTO();
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setEntityIdCode(10001);
        domainEntityCmdReqDTO.setDomainEntity(domainEntity);
        DomainEntityAttr domainEntityAttr = new DomainEntityAttr();
        domainEntityAttr.setAttrName("area");
        domainEntityAttr.setAttrType(AttrTypeEnum.INTEGER.getType());
        domainEntityAttr.setAttrDesc("面积");
        domainEntityCmdReqDTO.setEntityAttr(domainEntityAttr);
        Result<Boolean> result = domainEntityCmdService.addEntityAttr(domainEntityCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void testDelEntityAttr() {
        DomainEntityCmdReqDTO domainEntityCmdReqDTO = new DomainEntityCmdReqDTO();
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setEntityIdCode(100010);
        domainEntityCmdReqDTO.setDomainEntity(domainEntity);
        DomainEntityAttr domainEntityAttr = new DomainEntityAttr();
        domainEntityAttr.setEntityIdCode(100010);
        domainEntityAttr.setAttrName("address");
        domainEntityCmdReqDTO.setEntityAttr(domainEntityAttr);
        Result<Boolean> result = domainEntityCmdService.delEntityAttr(domainEntityCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }
}

