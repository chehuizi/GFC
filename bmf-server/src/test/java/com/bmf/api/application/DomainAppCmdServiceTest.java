package com.bmf.api.application;

import com.bmf.common.api.Result;
import com.bmf.design.api.application.DomainAppCmdService;
import com.bmf.design.api.application.dto.DomainAppCmdReqDTO;
import com.bmf.design.model.application.DomainApp;
import com.bmf.design.model.application.DomainAppApi;
import com.bmf.design.model.enums.DomainElementEnum;
import com.bmf.common.api.enums.ResultCodeEnum;
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
public class DomainAppCmdServiceTest {

    @Autowired
    private DomainAppCmdService domainAppCmdService;

    @Test
    public void test_domain_app_api_create() {
        DomainAppCmdReqDTO domainAppCmdReqDTO = new DomainAppCmdReqDTO();
        DomainApp domainApp = new DomainApp();
        domainApp.setDomainCode(101);
        domainApp.setDomainAlias("ims");
        domainApp.setAppId(1);
        domainApp.setAppName("app_ims");
        domainApp.setAppDesc("中央库存应用");
        domainAppCmdReqDTO.setDomainApp(domainApp);
        List<DomainAppApi> domainAppApiList = new ArrayList<>();
        DomainAppApi domainAppApi_1 = new DomainAppApi();
        domainAppApi_1.setDomainCode(domainApp.getDomainCode());
        domainAppApi_1.setDomainAlias(domainApp.getDomainAlias());
        domainAppApi_1.setDomainElementType(DomainElementEnum.DOMAIN_SERVICE.getElement());
        domainAppApi_1.setElementCode(10001);
        domainAppApi_1.setElementAlias("outbound_create_order_service");
        domainAppApi_1.setAppId(domainApp.getAppId());
        domainAppApi_1.setAppName(domainApp.getAppName());
        domainAppApi_1.setApiName("createOutboundOrder");
        domainAppApi_1.setApiPath("com.bmf.demo.api.OutboundService.createOutboundOrder");
        domainAppApi_1.setApiDesc("创建出库单");
        domainAppApiList.add(domainAppApi_1);
        DomainAppApi domainAppApi_2 = new DomainAppApi();
        domainAppApi_2.setDomainCode(domainApp.getDomainCode());
        domainAppApi_2.setDomainAlias(domainApp.getDomainAlias());
        domainAppApi_2.setDomainElementType(DomainElementEnum.DOMAIN_SERVICE.getElement());
        domainAppApi_2.setElementCode(10002);
        domainAppApi_2.setElementAlias("inbound_create_order_service");
        domainAppApi_2.setAppId(domainApp.getAppId());
        domainAppApi_2.setAppName(domainApp.getAppName());
        domainAppApi_2.setApiName("createInboundOrder");
        domainAppApi_2.setApiPath("com.bmf.demo.api.InboundService.createInboundOrder");
        domainAppApi_2.setApiDesc("创建入库单");
        domainAppApiList.add(domainAppApi_2);
        domainAppCmdReqDTO.setDomainAppApiList(domainAppApiList);
        Result<Boolean> result = domainAppCmdService.create(domainAppCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }
}
