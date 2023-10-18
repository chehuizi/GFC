package com.bmf.api.flow;

import com.bmf.design.api.Result;
import com.bmf.design.api.flow.BusinessFlowConfigCmdService;
import com.bmf.design.api.flow.dto.BusinessFlowConfigCmdReqDTO;
import com.bmf.design.base.Business;
import com.bmf.design.base.flow.BusinessFlow;
import com.bmf.design.common.enums.ResultCodeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessFlowConfigCmdServiceTest {

    @Autowired
    private BusinessFlowConfigCmdService businessFlowCmdService;

    @Test
    public void test_business_flow_create() {
        BusinessFlowConfigCmdReqDTO businessFlowConfigCmdReqDTO = new BusinessFlowConfigCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(102);
        businessFlowConfigCmdReqDTO.setBusiness(business);
        BusinessFlow businessFlow = new BusinessFlow();
        businessFlow.setBusinessCode(102);
        businessFlow.setFlowName("入库流程");
        businessFlow.setFlowAlias("inbound_flow");
        businessFlowConfigCmdReqDTO.setBusinessFlow(businessFlow);
        Result<Boolean> result = businessFlowCmdService.create(businessFlowConfigCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

}
