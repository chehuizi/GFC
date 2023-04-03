package com.bmf.api.application;

import com.bmf.api.Result;
import com.bmf.api.application.dto.BusinessApiCmdReqDTO;
import com.bmf.base.application.BusinessApi;
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
public class BusinessApiCmdServiceTest {

    @Autowired
    private BusinessApiCmdService businessApiCmdService;

    @Test
    public void test_business_api_create() {
        BusinessApiCmdReqDTO businessApiCmdReqDTO = new BusinessApiCmdReqDTO();
        List<BusinessApi> businessApiList = new ArrayList<>();
        BusinessApi businessApi_1 = new BusinessApi();
        businessApi_1.setApiName("createOutboundOrder");
        businessApi_1.setApiPath("com.bmf.demo.api.OutboundService.createOutboundOrder");
        businessApi_1.setApiDesc("创建出库单");
        businessApi_1.setServiceCode(10001);
        businessApi_1.setServiceAlias("outbound_create_order_service");
        businessApiList.add(businessApi_1);
        BusinessApi businessApi_2 = new BusinessApi();
        businessApi_2.setApiName("createInboundOrder");
        businessApi_2.setApiPath("com.bmf.demo.api.InboundService.createInboundOrder");
        businessApi_2.setApiDesc("创建入库单");
        businessApi_2.setServiceCode(10002);
        businessApi_2.setServiceAlias("inbound_create_order_service");
        businessApiList.add(businessApi_2);
        businessApiCmdReqDTO.setBusinessApiList(businessApiList);
        Result<Boolean> result = businessApiCmdService.create(businessApiCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}
