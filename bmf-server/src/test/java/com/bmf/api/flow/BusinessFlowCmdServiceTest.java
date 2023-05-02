package com.bmf.api.flow;

import com.bmf.api.Result;
import com.bmf.api.flow.dto.BusinessFlowCmdReqDTO;
import com.bmf.base.Business;
import com.bmf.base.enums.BusinessFlowNodeTypeEnum;
import com.bmf.base.enums.DomainElementEnum;
import com.bmf.base.flow.BusinessFlow;
import com.bmf.base.flow.BusinessFlowNode;
import com.bmf.common.enums.ResultCodeEnum;
import org.junit.Assert;
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
        Result<Boolean> result = businessFlowCmdService.create(businessFlowCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(ResultCodeEnum.SUCCESS.getCode() == result.getCode());
    }

    @Test
    public void test_business_flow_add_node() {
        BusinessFlowCmdReqDTO businessFlowCmdReqDTO = new BusinessFlowCmdReqDTO();
        BusinessFlow businessFlow = new BusinessFlow();
        businessFlow.setFlowId(1001);
        businessFlowCmdReqDTO.setBusinessFlow(businessFlow);
        BusinessFlowNode flowNode = new BusinessFlowNode();
        flowNode.setFlowId(1001);
        flowNode.setNodeName("预约入库");
        flowNode.setNodeAlias("apply_inbound");
        flowNode.setNodeType(BusinessFlowNodeTypeEnum.DOMAIN.getType());
        flowNode.setDomainElement(DomainElementEnum.DOMAIN_SERVICE.getElement());
        flowNode.setElementId(10004);
        businessFlowCmdReqDTO.setBusinessFlowNode(flowNode);
        Result<Boolean> result = businessFlowCmdService.addFlowNode(businessFlowCmdReqDTO);
        System.out.println(result);
        Assert.assertTrue(result.getData());
    }
}
