package com.bmf.api.flow;

import com.bmf.api.flow.dto.BusinessFlowCmdReqDTO;
import com.bmf.base.Business;
import com.bmf.base.flow.BusinessFlow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessFlowCmdServiceTest {

    @Autowired
    private BusinessFlowCmdService businessFlowCmdService;

    @Test
    public void test_business_flow_create() {
        BusinessFlowCmdReqDTO businessFlowCmdReqDTO = new BusinessFlowCmdReqDTO();
        Business business = new Business();
        business.setBusinessCode(102);
        businessFlowCmdReqDTO.setBusiness(business);
        BusinessFlow businessFlow = new BusinessFlow();
        businessFlow.setBusinessCode(102);
        businessFlow.setFlowName("入库流程");
        businessFlow.setFlowAlias("inbound_flow");
        businessFlow.setRoleId(10002);
        businessFlowCmdReqDTO.setBusinessFlow(businessFlow);
        businessFlowCmdService.create(businessFlowCmdReqDTO);
    }
}
