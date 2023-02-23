package com.bmf.api;

import com.bmf.api.domain.DomainValueObjectCmdService;
import com.bmf.api.domain.dto.DomainServiceReqDTO;
import com.bmf.api.domain.dto.DomainValueObjectReqDTO;
import com.bmf.base.enums.AttrTypeEnum;
import com.bmf.base.tactics.service.DomainService;
import com.bmf.base.tactics.service.DomainServiceAttr;
import com.bmf.base.tactics.valueobject.DomainValueObject;
import com.bmf.base.tactics.valueobject.DomainValueObjectAttr;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainValueObjectCmdServiceTest {

    @Autowired
    private DomainValueObjectCmdService domainValueObjectCmdService;

    @Test
    public void testAddValueObjectAttr() {
        DomainValueObjectReqDTO valueObjectReqDTO = new DomainValueObjectReqDTO();
        DomainValueObject domainValueObject = new DomainValueObject();
        domainValueObject.setVoCode(103);
        DomainValueObjectAttr valueObjectAttr = new DomainValueObjectAttr();
        valueObjectAttr.setVoCode(103);
        valueObjectAttr.setAttrName("provinceName");
        valueObjectAttr.setAttrType(AttrTypeEnum.STRING.getType());
        valueObjectAttr.setAttrDesc("省名称");
        valueObjectReqDTO.setDomainValueObject(domainValueObject);
        valueObjectReqDTO.setValueObjectAttr(valueObjectAttr);
        Result<Boolean> result = domainValueObjectCmdService.addValueObjectAttr(valueObjectReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void testDelValueObjectAttr() {
        DomainValueObjectReqDTO valueObjectReqDTO = new DomainValueObjectReqDTO();
        DomainValueObjectAttr valueObjectAttr = new DomainValueObjectAttr();
        valueObjectAttr.setVoCode(103);
        valueObjectAttr.setAttrName("provinceName");
        valueObjectReqDTO.setValueObjectAttr(valueObjectAttr);
        Result<Boolean> result = domainValueObjectCmdService.delValueObjectAttr(valueObjectReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }
}

