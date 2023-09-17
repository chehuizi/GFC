package com.bmf.api.application;

import com.bmf.api.Result;
import com.bmf.api.application.dto.DomainApiCmdReqDTO;
import com.bmf.base.application.DomainApi;
import com.bmf.common.enums.ResultCodeEnum;
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
public class DomainApiCmdServiceTest {

    @Autowired
    private DomainApiCmdService domainApiCmdService;

    @Test
    public void test_business_api_create() {
        DomainApiCmdReqDTO domainApiCmdReqDTO = new DomainApiCmdReqDTO();
        List<DomainApi> domainApiList = new ArrayList<>();
        DomainApi domainApi_1 = new DomainApi();
        domainApi_1.setApiName("createOutboundOrder");
        domainApi_1.setApiPath("com.bmf.demo.api.OutboundService.createOutboundOrder");
        domainApi_1.setApiDesc("创建出库单");
        domainApi_1.setServiceCode(10001);
        domainApi_1.setServiceAlias("outbound_create_order_service");
        domainApiList.add(domainApi_1);
        DomainApi domainApi_2 = new DomainApi();
        domainApi_2.setApiName("createInboundOrder");
        domainApi_2.setApiPath("com.bmf.demo.api.InboundService.createInboundOrder");
        domainApi_2.setApiDesc("创建入库单");
        domainApi_2.setServiceCode(10002);
        domainApi_2.setServiceAlias("inbound_create_order_service");
        domainApiList.add(domainApi_2);
        domainApiCmdReqDTO.setDomainApiList(domainApiList);
        Result<Boolean> result = domainApiCmdService.create(domainApiCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}
