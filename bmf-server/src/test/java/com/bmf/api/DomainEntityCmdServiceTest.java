package com.bmf.api;

import com.bmf.api.domain.DomainEntityCmdService;
import com.bmf.api.domain.dto.DomainEntityReqDTO;
import com.bmf.base.enums.AttrTypeEnum;
import com.bmf.base.tactics.entity.DomainEntity;
import com.bmf.base.tactics.entity.DomainEntityAttr;
import com.bmf.common.enums.ResultCodeEnum;
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
        DomainEntityReqDTO domainEntityReqDTO = new DomainEntityReqDTO();
        DomainEntity domainEntity = new DomainEntity();
        domainEntity.setEntityIdCode(100010);
        domainEntityReqDTO.setDomainEntity(domainEntity);
        DomainEntityAttr domainEntityAttr = new DomainEntityAttr();
        domainEntityAttr.setAttrName("address");
        domainEntityAttr.setAttrType(AttrTypeEnum.STRING.getType());
        domainEntityAttr.setAttrDesc("仓库地址");
        domainEntityReqDTO.setEntityAttr(domainEntityAttr);
        Result<Boolean> result = domainEntityCmdService.addEntityAttr(domainEntityReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void testDelEntityAttr() {
        DomainEntityReqDTO domainEntityReqDTO = new DomainEntityReqDTO();
        DomainEntityAttr domainEntityAttr = new DomainEntityAttr();
        domainEntityAttr.setEntityIdCode(100010);
        domainEntityAttr.setAttrName("address");
        domainEntityReqDTO.setEntityAttr(domainEntityAttr);
        Result<Boolean> result = domainEntityCmdService.delEntityAttr(domainEntityReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }
}

