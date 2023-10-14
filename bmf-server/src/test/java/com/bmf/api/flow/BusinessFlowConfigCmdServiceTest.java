package com.bmf.api.flow;

import com.bmf.design.api.Result;
import com.bmf.design.api.flow.BusinessFlowConfigCmdService;
import com.bmf.design.api.flow.dto.BusinessFlowConfigCmdReqDTO;
import com.bmf.design.base.Business;
import com.bmf.design.base.enums.BusinessFlowNodeTypeEnum;
import com.bmf.design.base.flow.BusinessFlow;
import com.bmf.design.base.flow.BusinessFlowNode;
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

    @Test
    public void test_business_flow_add_node() {
        BusinessFlowConfigCmdReqDTO businessFlowConfigCmdReqDTO = new BusinessFlowConfigCmdReqDTO();
        BusinessFlow businessFlow = new BusinessFlow();
        businessFlow.setBusinessCode(102);
        businessFlow.setFlowId(1001);
        businessFlowConfigCmdReqDTO.setBusinessFlow(businessFlow);
        BusinessFlowNode flowNode = new BusinessFlowNode();
        flowNode.setFlowId(1001);
        flowNode.setNodeName("预约入库");
        flowNode.setNodeAlias("apply_inbound");
        flowNode.setNodeType(BusinessFlowNodeTypeEnum.DOMAIN.getType());
        businessFlowConfigCmdReqDTO.setBusinessFlowNode(flowNode);
        Result<Boolean> result = businessFlowCmdService.addFlowNode(businessFlowConfigCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }
}
