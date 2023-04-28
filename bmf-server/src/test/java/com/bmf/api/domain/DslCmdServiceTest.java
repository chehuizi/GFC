package com.bmf.api.domain;

import com.bmf.api.Result;
import com.bmf.api.domain.cmd.DslCmdService;
import com.bmf.api.domain.dto.DslCmdReqDTO;
import com.bmf.base.dsl.BusinessDslExt;
import com.bmf.base.enums.AttrTypeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DslCmdServiceTest {

    @Autowired
    private DslCmdService dslCmdService;

    @Test
    public void testAddDslExt() {
        DslCmdReqDTO dslCmdReqDTO = new DslCmdReqDTO();
        List<BusinessDslExt> dslExtList = new ArrayList<>();
        BusinessDslExt dslExt1 = new BusinessDslExt();
        dslExt1.setDslCode(1000001);
        dslExt1.setDslExtType(AttrTypeEnum.BOOLEAN.getType());
        dslExt1.setDslExtKey("hasGB");
        dslExt1.setDslExtVal("Y");
        dslExtList.add(dslExt1);
        BusinessDslExt dslExt2 = new BusinessDslExt();
        dslExt2.setDslCode(1000009);
        dslExt2.setDslExtType(AttrTypeEnum.STRING.getType());
        dslExt2.setDslExtKey("wiki");
        dslExt2.setDslExtVal("https://www.baidu.com/");
        dslExtList.add(dslExt2);
        dslCmdReqDTO.setDslExtList(dslExtList);
        Result<Boolean> result = dslCmdService.addDslExt(dslCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }

    @Test
    public void testDelDslExt() {
        DslCmdReqDTO dslCmdReqDTO = new DslCmdReqDTO();
        BusinessDslExt dslExt = new BusinessDslExt();
        dslExt.setDslCode(1000009);
        dslExt.setDslExtKey("hasGB");
        dslCmdReqDTO.setDslExt(dslExt);
        Result<Boolean> result = dslCmdService.delDslExt(dslCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }
}
